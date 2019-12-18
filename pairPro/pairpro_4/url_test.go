package url

import (
	"fmt"
	"reflect"
	"testing"
)

func TestIsHttp(t *testing.T) {
	cases := []struct {
		in   string
		want bool
	}{
		{"http://neo.co.test", true},
		{"https://neo.co.jp", false},
		{"http:/neo.co.jp", false},
		{"http:/", false},
		{"", false},
	}

	for _, c := range cases {
		testUrl := Url{url: c.in}
		got := testUrl.IsHttp()
		if got != c.want {
			t.Errorf("original = %q, IsHttp() = %t, want %t", c.in, got, c.want)
		}
	}
}

func TestPickUpHost(t *testing.T) {
	cases := []struct {
		in   string
		want string
	}{
		{"http://neo.co.test/aaa/bb?key1=aaa&key2=bbb", "neo.co.test"},
		{"https://neo.co.test/aaa/bb?key1=aaa&key2=bbb", "neo.co.test"},

		{"http://neo.co.test/aaa/bb?", "neo.co.test"},
		{"https://neo.co.test/aaa/bb?", "neo.co.test"},

		{"http://neo.co.test/aaa/bb", "neo.co.test"},
		{"https://neo.co.test/aaa/bb", "neo.co.test"},

		{"http://neo.co.test/", "neo.co.test"},
		{"https://neo.co.test/", "neo.co.test"},

		{"http://neo.co.test/?key1=aaa&key2=bbb", "neo.co.test"},
		{"https://neo.co.test/?key1=aaa&key2=bbb", "neo.co.test"},

		{"http://neo.co.test?key1=aaa&key2=bbb", "neo.co.test"},
		{"https://neo.co.test?key1=aaa&key2=bbb", "neo.co.test"},

		{"http://neo.co.test?", "neo.co.test"},
		{"https://neo.co.test?", "neo.co.test"},

		{"http://neo.co.test", "neo.co.test"},
		{"https://neo.co.test", "neo.co.test"},

		{"http://", ""},
		{"https://", ""},

		// "http://neo.co.test:8080/aaa/bb?key1=aaa&key2=bbb"
		// 上記のように、ポート番号を指定することもある (未テスト)
	}

	for _, c := range cases {
		testUrl := Url{url: c.in}
		testUrl.pickUpHost()
		got := testUrl.host
		if got != c.want {
			t.Errorf("original = %q, host = %q, want %q", c.in, got, c.want)
		}
	}
}

func TestPickUpPath(t *testing.T) {
	cases := []struct {
		in   string
		want string
	}{
		{"http://neo.co.test/aaa/bb?key1=aaa&key2=bbb", "aaa/bb"},
		{"https://neo.co.test/aaa/bb?key1=aaa&key2=bbb", "aaa/bb"},

		{"http://neo.co.test/aaa/bb?", "aaa/bb"},
		{"https://neo.co.test/aaa/bb?", "aaa/bb"},

		{"http://neo.co.test/aaa/bb", "aaa/bb"},
		{"https://neo.co.test/aaa/bb", "aaa/bb"},

		{"http://neo.co.test/", ""},
		{"https://neo.co.test/", ""},

		{"http://neo.co.test/?key1=aaa&key2=bbb", ""},
		{"https://neo.co.test/?key1=aaa&key2=bbb", ""},

		{"http://neo.co.test?key1=aaa&key2=bbb", ""},
		{"https://neo.co.test?key1=aaa&key2=bbb", ""},

		{"http://neo.co.test?", ""},
		{"https://neo.co.test?", ""},

		{"http://neo.co.test", ""},
		{"https://neo.co.test", ""},

		{"http://", ""},
		{"https://", ""},
		// "http://neo.co.test:8080/aaa/bb?key1=aaa&key2=bbb"
		// 上記のように、ポート番号を指定することもある (未テスト)
	}

	for _, c := range cases {
		testUrl := Url{url: c.in}
		testUrl.pickUpPath()
		got := testUrl.path
		if got != c.want {
			t.Errorf("original = %q, path = %q, want = %q", c.in, got, c.want)
		}
	}
}

func TestAnalyzeQuery(t *testing.T) {
	cases := []struct {
		in   string
		want map[string]string
	}{
		{"http://neo.co.test/aaa/bb?key1=aaa&key2=bbb", map[string]string{"key1": "aaa", "key2": "bbb"}},
		{"https://neo.co.test/aaa/bb?key1=aaa&key2=bbb", map[string]string{"key1": "aaa", "key2": "bbb"}},

		{"http://neo.co.test/aaa/bb?", map[string]string{}},
		{"https://neo.co.test/aaa/bb?", map[string]string{}},

		{"http://neo.co.test/aaa/bb", map[string]string{}},
		{"https://neo.co.test/aaa/bb", map[string]string{}},

		{"http://neo.co.test/", map[string]string{}},
		{"https://neo.co.test/", map[string]string{}},

		{"http://neo.co.test/?key1=aaa&key2=bbb", map[string]string{"key1": "aaa", "key2": "bbb"}},
		{"https://neo.co.test/?key1=aaa&key2=bbb", map[string]string{"key1": "aaa", "key2": "bbb"}},

		{"http://neo.co.test?key1=aaa&key2=bbb", map[string]string{"key1": "aaa", "key2": "bbb"}},
		{"https://neo.co.test?key1=aaa&key2=bbb", map[string]string{"key1": "aaa", "key2": "bbb"}},

		{"http://neo.co.test?", map[string]string{}},
		{"https://neo.co.test?", map[string]string{}},

		{"http://neo.co.test", map[string]string{}},
		{"https://neo.co.test", map[string]string{}},

		{"http://", map[string]string{}},
		{"https://", map[string]string{}},
	}

	for _, c := range cases {
		testUrl := Url{url: c.in}
		testUrl.analyzeQuery()
		got := testUrl.param
		if !reflect.DeepEqual(got, c.want) {
			t.Errorf("original = %q, map = %q, want = %T", c.in, got, c.want)
		}
	}
}

func TestNewUrl(t *testing.T) {
	cases := []struct {
		in        string
		wantHost  string
		wantPath  string
		inKey     string
		wantValue string
	}{
		{"http://neo.co.test/aaa/bb?key1=aaa&key2=bbb", "neo.co.test", "aaa/bb", "key1", "aaa"},
	}
	for _, c := range cases {
		testUrl := NewUrl(c.in)
		testHost := testUrl.Host()
		testPath := testUrl.Path()
		testValue := testUrl.GetValueFrom(c.inKey)

		if !(testHost == c.wantHost && testPath == c.wantPath && testValue == c.wantValue) {
			t.Errorf("Error!")
		}
	}
}
