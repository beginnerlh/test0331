/*
 * 牌组中的每张卡牌都对应有一个唯一的整数。你可以按你想要的顺序对这套卡片进行排序。
最初，这些卡牌在牌组里是正面朝下的（即，未显示状态）。
现在，重复执行以下步骤，直到显示所有卡牌为止：
从牌组顶部抽一张牌，显示它，然后将其从牌组中移出。
如果牌组中仍有牌，则将下一张处于牌组顶部的牌放在牌组的底部。
如果仍有未显示的牌，那么返回步骤 1。否则，停止行动。
返回能以递增顺序显示卡牌的牌组顺序。
答案中的第一张牌被认为处于牌堆顶部。

示例：

输入：[17,13,11,2,3,5,7]
输出：[2,13,3,11,5,17,7]
解释：
我们得到的牌组顺序为 [17,13,11,2,3,5,7]（这个顺序不重要），然后将其重新排序。
重新排序后，牌组以 [2,13,3,11,5,17,7] 开始，其中 2 位于牌组的顶部。
我们显示 2，然后将 13 移到底部。牌组现在是 [3,11,5,17,7,13]。
我们显示 3，并将 11 移到底部。牌组现在是 [5,17,7,13,11]。
我们显示 5，然后将 17 移到底部。牌组现在是 [7,13,11,17]。
我们显示 7，并将 13 移到底部。牌组现在是 [11,17,13]。
我们显示 11，然后将 17 移到底部。牌组现在是 [13,17]。
我们展示 13，然后将 17 移到底部。牌组现在是 [17]。
我们显示 17。
由于所有卡片都是按递增顺序排列显示的，所以答案是正确的。
*/
package lianxi0331;

import java.util.*;
public class test0331 {
	public static void main(String[] args) {
		Solution S = new Solution();
		int[] deck = new int[] {17,13,11,2,3,5,7};
		int[] a = S.deckRevealedIncreasing(deck);
		for(int i : a) {
			System.out.print(i+" ");
		}
	}
	
}

class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        int[] a = new int[deck.length];
        Arrays.sort(deck);//原数组排序
        if(deck.length == 1){//如果长度为1 直接返回数组
            return deck;
        }
        int len = deck.length - 1;
        a[len] = deck[len]; //将数组后两位值付给数组a
        a[len - 1] = deck[len -1];
        for(int i = len -2; i> -1;i--){
            a[i] = deck[i]; //插入元素
            int tmp = a[len];//用临时变量存最后一位
            System.arraycopy(a,i+1,a,i+2,len-i-1) ;//将除了插入的元素和最后一位元素向后依次移动一位
            //System.arraycopy(源数组名称，源数组开始点，目标数组名称，目标数组开始点，拷贝长度);
            a[i+ 1] = tmp;//放到插入的数组之后
        }
        return a;
    }
}