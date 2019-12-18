package url

import (
	"regexp"
	"strings"
	// "fmt"
)

// comment
type Url struct {
	url   string
	host  string
	path  string
	param map[string]string
}

// NewUrl initializes Url
func NewUrl(inputUrl string) *Url {
	newUrl := Url{url: inputUrl}
	newUrl.pickUpHost()
	newUrl.pickUpPath()
	newUrl.analyzeQuery()
	return &newUrl
}

// IsHttp reports whether inputUrl starts with "http://"
func (inputUrl *Url) IsHttp() bool {
	return strings.HasPrefix(inputUrl.url, "http://")
}

// comment
func (inputUrl *Url) Host() string {
	return inputUrl.host
}

// comment
func (inputUrl *Url) Path() string {
	return inputUrl.path
}

// comment
func (inputUrl *Url) GetValueFrom(key string) string {
	return inputUrl.param[key]
}

// comment
func (inputUrl *Url) pickUpHost() {
	var inputHost string

	re := regexp.MustCompile(`^[a-z|A-Z]*://`)
	inputHost = re.ReplaceAllString(inputUrl.url, "")

	re = regexp.MustCompile(`[\/|\?].*`)
	inputHost = re.ReplaceAllString(inputHost, "")

	inputUrl.host = inputHost
}

// comment
func (inputUrl *Url) pickUpPath() {
	var inputPath string

	re := regexp.MustCompile(`^[a-z|A-Z]*://`)
	inputPath = re.ReplaceAllString(inputUrl.url, "")

	re = regexp.MustCompile(`^[a-z|A-Z|\.]*/`)
	if re.MatchString(inputPath) {
		inputPath = re.ReplaceAllString(inputPath, "")
	} else {
		inputPath = ""
	}

	re = regexp.MustCompile(`[\?].*$`)
	inputPath = re.ReplaceAllString(inputPath, "")

	inputUrl.path = inputPath
}

// comment
func (inputUrl *Url) analyzeQuery() {

	trimHead := regexp.MustCompile(`^[a-z|A-Z|:|.|\/]*\?`)
	queryStr := trimHead.ReplaceAllString(inputUrl.url, "")

	sepQuery := regexp.MustCompile(`&`)
	querySlice := sepQuery.Split(queryStr, -1)

	// 初期値を設定していない map に値を入れようとすると panic が発生するため
	// 空の map で初期化が必要
	inputUrl.param = map[string]string{}

	sepParam := regexp.MustCompile(`=`)
	// i はスライスの要素番号
	// _, param := querySlice とすると、param には querySlice の各要素のコピーが順に入る
	// 今回は _, param := querySlice querySlice でもよいが
	// 各要素の値を変更する場合は i = querySlice として
	// querySlice[i] = "変更値" としないと変更が反映されない
	// それか、querySlice をポインタに変換すれば良さそう？
	for i := range querySlice {
		if sepParam.MatchString(querySlice[i]) {
			keyValue := sepParam.Split(querySlice[i], -1)
			inputUrl.param[keyValue[0]] = keyValue[1]
		}
	}
}
