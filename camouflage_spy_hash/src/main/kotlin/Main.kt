fun main() {
    val param = arrayOf(arrayOf("yellow_hat", "headgear"),
        arrayOf("blue_sunglasses", "eyewear"),
        arrayOf("green_turban", "headgear"))
    println(Solution().solution(param))
}

class Solution {
    fun solution(clothes: Array<Array<String>>): Int {
        val mapClothes = HashMap<String, Int>()

        // 해시로 해당 옷을 입는 부위로 분류하고,
        for (clothe in clothes) {
            val type: String = clothe[1]
            if (mapClothes.containsKey(type)) {
                mapClothes[type] = mapClothes[type]!!.plus(1)
            } else {
                mapClothes[type] = 1
            }
        }

        /*
         조합 계산
         얼굴 : 안입음, 옷1, 옷2 ...
         안경 : 안씀, 안경1, 안경2...
         ...

         각각 동시에 일어나는 일이므로 곱의 법칙을 이용 각 경우의 수를 곱 함.
         (아래의 i + 1은 안입는 경우의 수를 추가해준 것이다.)
         그리고, 모두 안입는 경우는 없으니까 곱한 값에 -1을 해준다.
         */

        return mapClothes.values.fold(1) { acc, i -> acc * (i + 1) }.minus(1)
    }
}