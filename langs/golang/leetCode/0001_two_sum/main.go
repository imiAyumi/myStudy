/*
Problems.
Given an array of integers, return indices of the two numbers such that they add up to a specific target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.

問題 (意訳)
引数：整数の配列 nums、とある数値 target
戻り値：加算すると target と一致する nums 中の 2 つの数値のインデックス

その他の条件：
・必ず解が存在する
・解は 1 つだけ
・同じ要素は 2 回使えない
*/
package main

import "fmt"

func main() {
	nums := []int{1, 2, 3}
	target := 4

	result := twoSum(nums, target)
	fmt.Printf("%v\n", result)
}

func twoSum(nums []int, target int) []int {
	var result []int
	for i := 0; i < len(nums)-1; i++ {
		for k := i + 1; k < len(nums); k++ {
			if nums[i]+nums[k] == target {
				result = append(result, i)
				result = append(result, k)
				return result
			}
		}
	}
	return nil
}
