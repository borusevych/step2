package lesson05;

public class ShoesApp {

  static int shelfSize(String raw) {
    int l = 0;
    int r = 0;
    int max = 0;
    for (char c : raw.toCharArray()) {
      switch (c) {
        case 'L':
          if (r == 0) l++;
          else r--;
          break;
        case 'R':
          if (l == 0) r++;
          else l--;
          break;
        default:
      }
      max = Math.max(max, Math.max(l, r));
    }
    return max - 1;
  }

  public static void main(String[] args) {
    System.out.println(shelfSize("LR"));// 0
    System.out.println(shelfSize("LLR")); // 1
    System.out.println(shelfSize("LLLRRRLLRRLRLLLLLRRRRR")); // 4
  }

}
