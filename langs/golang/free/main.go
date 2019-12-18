package main

import "fmt"

func main() {

	var k int

	fmt.Printf("\n数値")
	fmt.Printf("val：%+v, pointer：%p\n", k, &k)
	// k がどこかのメモリ領域のに付けられた名前なら、%p が出ないのおかしくない？？
	// → フォーマットの問題。%p はそもそも pointer 型のためのフォーマッタなので、
	// int だとそりゃあエラーになる
	// あと、kp の %v と %p の値が同じなのは、%v が「一般的な値を表示する」だから
	// ポインタ型の一般的な表示方法で表示してるだけ

	var s []int
	fmt.Printf("\nslc_null\n")
	fmt.Printf("val：%+v, pointer：%p\n", s, &s)

	s = make([]int, 1)
	fmt.Printf("\nslc_new1\n")
	fmt.Printf("val：%+v, pointer：%p\n", s, &s)

	s = make([]int, 2)
	fmt.Printf("\nslc_new2\n")
	fmt.Printf("val：%+v, pointer：%p\n", s, &s)

	addSlice(&s)

	fmt.Printf("\nslc_after_func\n")
	fmt.Printf("val：%+v, pointer：%p\n", s, &s)
}

func addSlice(s *[]int) {
	*s = make([]int, 3)
	fmt.Printf("\nslc_func\n")
	fmt.Printf("val：%+v, pointer：%p\n", *s, &*s)
	fmt.Printf("val：%+v, pointer：%p\n", s, &s)
}

func changeA(a int) {
	fmt.Printf("3: %v, %p\n", a, a)
	a = 3
	fmt.Printf("4: %v, %p\n", a, a)
}
