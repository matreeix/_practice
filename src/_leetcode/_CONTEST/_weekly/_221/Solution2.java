package _leetcode._CONTEST._weekly._221;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Description: 5638. 吃苹果的最大数目
 * 有一棵特殊的苹果树，一连 n 天，每天都可以长出若干个苹果。在第 i 天，树上会长出 apples[i] 个苹果，
 * 这些苹果将会在 days[i] 天后（也就是说，第 i + days[i] 天时）腐烂，变得无法食用。也可能有那么几天，树上不会长出新的苹果，此时用 apples[i] == 0 且 days[i] == 0 表示。
 * 你打算每天 最多 吃一个苹果来保证营养均衡。注意，你可以在这 n 天之后继续吃苹果。
 * 给你两个长度为 n 的整数数组 days 和 apples ，返回你可以吃掉的苹果的最大数目。
 * @Date: 2020/12/27
 */

public class Solution2 {
    //LTE
    public static int eatenApples(int[] apples, int[] days) {
        Queue<Integer> q = new PriorityQueue<>();
        int eat = 0, day = 0;
        double time1 = System.currentTimeMillis();
        for (int a : apples) {
            if (a == 0) day++;
            else break;
        }
        double time2 = System.currentTimeMillis();
        System.out.println(time2 - time1);
        for (int i = 0; i < apples.length; i++) {
            int tmp = apples[i];
            while (tmp-- > 0)
                q.add(i + days[i]);
        }
        double time3 = System.currentTimeMillis();
        System.out.println(time3 - time2);

        while (q.size() > 0) {
            if (q.poll() > day) {
                eat++;
                day++;
            }
        }
        double time4 = System.currentTimeMillis();
        System.out.println(time4 - time3);
        return eat;
    }

    //优先队列
    public static int eatenApples2(int[] apples, int[] days) {
        // 优先队列，队首是最早过期的  int[0]:苹果个数  int[1]:过期时间
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[1] < o2[1] ? -1 : 1);
        int eatNum = 0;
        for (int i = 0; i < apples.length || queue.size() > 0; i++) {
            //1.移除过期的
            while (!queue.isEmpty()) {
                int[] apple = queue.peek();
                if (apple[1] <= i) {
                    queue.poll();
                } else {
                    break;
                }
            }
            //2.添加当天新长出来的
            if (i < apples.length && apples[i] > 0) {
                queue.add(new int[]{apples[i], days[i] + i});
            }
            //3.吃掉已有的（优先吃最早过期的）
            int[] ap = queue.peek();
            if (ap != null && ap[0] > 0) {
                eatNum++;
                ap[0] -= 1;
                if (ap[0] == 0) {
                    queue.poll();
                }
            }
        }
        return eatNum;
    }

    //贪心
    public int eatenApples3(int[] apples, int[] days) {
        if (apples.length == 1)
            return Math.min(days[0], apples[0]);
        int n = apples.length, EndDay = 0, ZeroDay = 0;
        for (int i = 0; i < n; ++i) {
            if (apples[i] != 0 && i + days[i] > EndDay)
                EndDay = i + days[i];
            if (i >= EndDay) //空闲的天数
                ZeroDay++;
        }
        return EndDay - ZeroDay;
    }


    public static void main(String[] args) {
        int[] apples = {81, 13, 317, 0, 16, 276, 0, 0, 0, 392, 34, 27, 0, 0, 0, 345, 374, 338, 16, 0, 24, 0, 354, 258, 11, 0, 0, 161, 209, 345, 366, 168, 23, 383, 0, 116, 0, 347, 201, 0, 242, 212, 229, 406, 0, 0, 110, 80, 397, 429, 0, 85, 2, 56, 0, 0, 206, 345, 384, 122, 312, 0, 398, 0, 5, 48, 193, 311, 0, 385, 238, 12, 359, 273, 202, 399, 0, 188, 0, 0, 298, 0, 244, 0, 131, 0, 441, 375, 0, 0, 266, 125, 0, 149, 0, 431, 102, 50, 60, 269, 150, 77, 321, 53, 0, 389, 0, 11, 257, 0, 303, 0, 412, 253, 422, 378, 268, 39, 187, 385, 0, 276, 242, 0, 159, 0, 86, 430, 210, 0, 132, 353, 193, 0, 0, 0, 0, 37, 0, 0, 0, 0, 0, 181, 443, 0, 19, 0, 345, 376, 150, 0, 343, 160, 0, 209, 0, 210, 0, 317, 179, 201, 13, 153, 293, 392, 47, 125, 67, 202, 164, 68, 0, 0, 201, 0, 28, 431, 0, 56, 440, 270, 33, 355, 0, 120, 167, 92, 0, 312, 112, 0, 143, 346, 320, 120, 310, 323, 0, 298, 133, 0, 65, 0, 425, 0, 361, 52, 291, 0, 27, 0, 0, 297, 336, 418, 374, 0, 383, 265, 293, 223, 0, 435, 359, 362, 409, 16, 0, 168, 265, 0, 0, 72, 33, 0, 0, 0, 0, 345, 94, 104, 0, 116, 100, 148, 129, 363, 0, 362, 252, 119, 110, 188, 0, 0, 32, 127, 0, 384, 0, 230, 253, 0, 57, 0, 55, 64, 0, 0, 230, 263, 0, 186, 0, 77, 0, 119, 89, 273, 0, 281, 93, 246, 266, 0, 0, 0, 216, 434, 162, 190, 23, 0, 361, 140, 160, 157, 325, 276, 39, 27, 0, 0, 368, 0, 405, 0, 0, 0, 167, 0, 392, 96, 115, 226, 118, 13, 281, 444, 326, 124, 306, 257, 0, 22, 328, 192, 0, 0, 225, 173, 167, 0, 400, 113, 2, 56, 236, 34, 0, 342, 54, 418, 178, 185, 33, 0, 0, 12, 365, 445, 70, 304, 0, 410, 303, 356, 196, 253, 0, 165, 195, 0, 121, 206, 419, 31, 211, 334, 176, 0, 194, 0, 277, 0, 0, 180, 424, 126, 329, 325, 412, 167, 2, 363, 270, 114, 97, 194, 146, 95, 400, 326, 135, 73, 413, 278, 74, 305, 389, 272, 117, 87, 213, 0, 254, 42, 432, 364, 436, 340, 367, 305, 49, 239, 43, 0, 229, 0, 128, 0, 0, 154, 127, 219, 326, 0, 261, 115, 115, 399, 137, 397, 176, 141, 329, 411, 0, 0, 0, 416, 237, 0, 185, 0, 0, 17, 300, 148, 35, 183, 0, 0, 0, 140, 309, 274, 350, 191, 0, 416, 134, 333, 226, 0, 102, 422, 303, 119, 139, 0, 0, 134, 13, 137, 286, 0, 287, 102, 0, 16, 0, 257, 113, 398, 0, 251, 71, 0, 401, 326, 351, 423, 8, 275, 381, 420, 183, 153, 404, 0, 0, 3, 223, 394, 0, 301, 67, 0, 305, 389, 170, 255, 366, 0, 52, 0, 0, 0, 380, 0, 0, 0, 363, 0, 0, 4, 0, 0, 400, 173, 373, 326, 139, 435, 107, 231, 318, 435, 0, 224, 0, 0, 0, 184, 0, 321, 416, 401, 271, 106, 89, 0, 96, 268, 206, 0, 223, 0, 0, 265, 360, 191, 283, 102, 78, 154, 0, 420, 0, 0, 0, 392, 182, 146, 0, 167, 308, 0, 368, 125, 270, 0, 413, 262, 303, 352, 49, 0, 160, 268, 0, 90, 24, 242, 0, 368, 81, 0, 323, 242, 260, 187, 113, 0, 43, 0, 73, 83, 0, 38, 36, 89, 314, 211, 222, 310, 262, 439, 0, 0, 0, 0, 168, 343, 0, 0, 264, 253, 110, 349, 0, 373, 0, 401, 74, 49, 0, 111, 158, 6, 0, 137, 415, 80, 68, 429, 208, 282, 201, 0, 167, 138, 209, 209, 0, 0, 0, 0, 58, 0, 220, 271, 279, 366, 385, 344, 290, 275, 367, 381, 37, 8, 0, 413, 0, 0, 377, 217, 0, 414, 301, 0, 1, 177, 129, 434, 0, 370, 403, 195, 0, 79, 441, 288, 399, 164, 193, 309, 92, 299, 0, 0, 432, 26, 198, 267, 231, 156, 45, 275, 354, 50, 61, 419, 230, 119, 0, 0, 65, 192, 69, 367, 0, 212, 95, 84, 258, 0, 0, 171, 377, 14, 268, 93, 327, 188, 0, 300, 0, 56, 0, 141, 0, 398, 332, 185, 411, 0, 357, 0, 208, 116, 185, 349, 331, 347, 0, 0, 157, 356, 5, 61, 377, 358, 90, 57, 276, 302, 97, 107, 14, 343, 376, 311, 317, 428, 0, 354, 0, 273, 184, 0, 351, 0, 360, 347, 302, 0, 173, 6, 0, 349, 0, 149, 0, 295, 360, 277, 261, 129, 15, 0, 16, 0, 313, 190, 68, 0, 348, 183, 241, 249, 0, 35, 234, 378, 0, 0, 278, 0, 343, 0, 278, 0, 0, 0, 380, 168, 198, 135, 255, 0, 189, 283, 412, 275, 72, 371, 173, 392, 0, 365, 32, 0, 28, 0, 338, 186, 0, 151, 425, 41, 336, 216, 75, 81, 0, 87, 244, 421, 221, 0, 407, 245, 267, 0, 433, 227, 377, 211, 361, 259, 342, 114, 0, 0, 159, 299, 0, 0, 165, 32, 130, 270, 410, 0, 116, 0, 0};
        int[] days = {34, 23, 585, 0, 13, 189, 0, 0, 0, 722, 63, 13, 0, 0, 0, 676, 624, 383, 20, 0, 32, 0, 111, 80, 9, 0, 0, 192, 242, 648, 309, 107, 33, 324, 0, 39, 0, 276, 128, 0, 405, 195, 129, 716, 0, 0, 33, 59, 356, 834, 0, 40, 4, 18, 0, 0, 121, 291, 34, 17, 204, 0, 765, 0, 1, 59, 376, 482, 0, 293, 472, 4, 332, 156, 135, 554, 0, 371, 0, 0, 283, 0, 54, 0, 117, 0, 452, 533, 0, 0, 88, 52, 0, 47, 0, 805, 164, 88, 82, 427, 163, 84, 368, 67, 0, 710, 0, 6, 512, 0, 352, 0, 62, 58, 95, 679, 461, 27, 84, 14, 0, 54, 39, 0, 308, 0, 106, 814, 55, 0, 10, 284, 75, 0, 0, 0, 0, 7, 0, 0, 0, 0, 0, 31, 801, 0, 33, 0, 413, 538, 22, 0, 324, 276, 0, 226, 0, 359, 0, 478, 118, 251, 1, 253, 223, 265, 85, 66, 85, 247, 22, 91, 0, 0, 92, 0, 40, 652, 0, 1, 561, 414, 42, 621, 0, 84, 45, 149, 0, 489, 215, 0, 167, 45, 567, 84, 446, 454, 0, 490, 3, 0, 27, 0, 648, 0, 258, 28, 513, 0, 29, 0, 0, 298, 573, 538, 686, 0, 71, 53, 17, 258, 0, 4, 151, 97, 338, 4, 0, 164, 503, 0, 0, 2, 33, 0, 0, 0, 0, 494, 97, 198, 0, 195, 192, 192, 141, 173, 0, 333, 269, 135, 22, 279, 0, 0, 50, 11, 0, 647, 0, 232, 241, 0, 11, 0, 43, 79, 0, 0, 277, 227, 0, 87, 0, 8, 0, 165, 173, 318, 0, 238, 91, 80, 283, 0, 0, 0, 230, 198, 106, 135, 46, 0, 190, 225, 3, 284, 257, 478, 59, 40, 0, 0, 527, 0, 22, 0, 0, 0, 238, 0, 757, 12, 165, 199, 199, 4, 436, 604, 220, 177, 327, 398, 0, 30, 13, 34, 0, 0, 269, 295, 320, 0, 416, 3, 1, 60, 242, 24, 0, 263, 92, 548, 160, 269, 47, 0, 0, 6, 65, 68, 53, 474, 0, 628, 578, 90, 191, 106, 0, 145, 28, 0, 104, 142, 408, 62, 369, 57, 330, 0, 349, 0, 131, 0, 0, 152, 821, 211, 395, 244, 8, 165, 3, 390, 323, 103, 2, 63, 13, 134, 580, 473, 63, 51, 384, 170, 138, 174, 311, 356, 134, 29, 173, 0, 157, 59, 395, 111, 399, 638, 329, 160, 78, 268, 57, 0, 423, 0, 41, 0, 0, 44, 152, 384, 11, 0, 25, 158, 46, 675, 190, 537, 314, 129, 305, 70, 0, 0, 0, 278, 53, 0, 159, 0, 0, 24, 130, 170, 57, 223, 0, 0, 0, 233, 123, 306, 377, 204, 0, 458, 140, 388, 21, 0, 17, 804, 113, 3, 219, 0, 0, 130, 25, 237, 561, 0, 81, 51, 0, 9, 0, 128, 203, 273, 0, 229, 103, 0, 720, 394, 213, 548, 6, 21, 190, 239, 251, 193, 428, 0, 0, 5, 3, 179, 0, 97, 53, 0, 145, 354, 98, 359, 113, 0, 102, 0, 0, 0, 287, 0, 0, 0, 231, 0, 0, 7, 0, 0, 86, 21, 526, 227, 13, 308, 145, 302, 530, 581, 0, 108, 0, 0, 0, 3, 0, 414, 340, 369, 507, 130, 57, 0, 170, 178, 226, 0, 411, 0, 0, 200, 120, 137, 147, 16, 7, 67, 0, 300, 0, 0, 0, 225, 40, 205, 0, 293, 312, 0, 597, 59, 119, 0, 383, 230, 193, 210, 71, 0, 116, 348, 0, 107, 10, 367, 0, 686, 21, 0, 349, 266, 478, 223, 100, 0, 19, 0, 93, 55, 0, 53, 30, 115, 266, 46, 155, 53, 405, 725, 0, 0, 0, 0, 173, 2, 0, 0, 90, 210, 54, 470, 0, 567, 0, 270, 57, 96, 0, 159, 79, 5, 0, 258, 426, 8, 11, 57, 400, 283, 339, 0, 298, 235, 314, 318, 0, 0, 0, 0, 57, 0, 304, 458, 123, 598, 759, 143, 554, 318, 486, 118, 12, 16, 0, 376, 0, 0, 191, 177, 0, 620, 424, 0, 2, 223, 127, 806, 0, 217, 561, 330, 0, 106, 564, 313, 578, 88, 131, 145, 102, 217, 0, 0, 837, 29, 123, 313, 412, 78, 88, 150, 531, 44, 11, 51, 162, 126, 0, 0, 101, 16, 95, 659, 0, 217, 172, 7, 494, 0, 0, 70, 1, 7, 129, 81, 222, 376, 0, 269, 0, 28, 0, 183, 0, 504, 501, 254, 263, 0, 450, 0, 406, 127, 352, 110, 427, 25, 0, 0, 162, 66, 7, 57, 595, 243, 73, 39, 39, 219, 37, 44, 2, 481, 152, 309, 396, 379, 0, 117, 0, 350, 81, 0, 81, 0, 690, 622, 22, 0, 57, 3, 0, 274, 0, 69, 0, 216, 286, 348, 434, 169, 18, 0, 19, 0, 397, 53, 27, 0, 690, 243, 198, 470, 0, 29, 276, 592, 0, 0, 23, 0, 285, 0, 525, 0, 0, 0, 500, 225, 231, 6, 325, 0, 10, 410, 38, 430, 80, 540, 267, 250, 0, 237, 62, 0, 34, 0, 602, 47, 0, 158, 55, 52, 553, 127, 42, 159, 0, 98, 354, 293, 424, 0, 706, 183, 443, 0, 292, 130, 458, 257, 319, 81, 398, 199, 0, 0, 267, 425, 0, 0, 141, 26, 162, 503, 103, 0, 210, 0, 0};
//        int[] apples = {1, 2, 3, 5, 2};
//        int[] days = {3, 2, 1, 4, 2};

        System.out.println(eatenApples2(apples, days));
    }
}