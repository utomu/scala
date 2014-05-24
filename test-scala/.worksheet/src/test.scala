object test {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(57); 
  println("Welcome to the Scala worksheet");$skip(354); 

  def countChange(money: Int, coins: List[Int]): Int = {
    def recurs(m: Int, cs: List[Int], cnt: Int): Int =
      if (m < 0) cnt //Not a change, keep cnt
      else if (cs.isEmpty) {
        if (m == 0) cnt + 1 else cnt // plus cnt if find a change
      } else recurs(m, cs.tail, cnt) + recurs(m - cs.head, cs, cnt)
    recurs(money, coins, 0)
  };System.out.println("""countChange: (money: Int, coins: List[Int])Int""");$skip(161); 

  def sum(money: Int, l: List[Int], denom: List[Int]): Int = {
    var s: Int = 0
    for (i: Int <- l.indices) {
      s = s + l(i) * denom(i)
    }
    s
  };System.out.println("""sum: (money: Int, l: List[Int], denom: List[Int])Int""");$skip(303); 

  def change(money: Int, denom: List[Int]) {
    def counter = List.fill(denom.size)(0)
    def r = Range(0, money)
    for (x <- counter.indices) {
      for (y <- r) {
        def p = counter.updated(x, y)
        if (sum(money, p, denom) == money) {
          println(p)
        }
      }
    }
  };System.out.println("""change: (money: Int, denom: List[Int])Unit""");$skip(229); 

  def comb(max: Int, size: Int) {
    var counter: List[Int] = List.fill(size)(0)
    for (x <- counter.indices) {
      for (r <- Range(0, max + 1)) {
        def p = counter.updated(x, r)
        println(p)
      }

    }
  };System.out.println("""comb: (max: Int, size: Int)Unit""");$skip(28); val res$0 = 

 countChange(10,List(2,5));System.out.println("""res0: Int = """ + $show(res$0));$skip(25); 
  change(10, List(1, 1));$skip(13); 
  comb(2, 3)}

}
