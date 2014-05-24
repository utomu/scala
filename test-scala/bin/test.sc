object test {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  def countChange(money: Int, coins: List[Int]): Int = {
    def recurs(m: Int, cs: List[Int], cnt: Int): Int =
      if (m < 0) cnt //Not a change, keep cnt
      else if (cs.isEmpty) {
        if (m == 0) cnt + 1 else cnt // plus cnt if find a change
      } else recurs(m, cs.tail, cnt) + recurs(m - cs.head, cs, cnt)
    recurs(money, coins, 0)
  }                                               //> countChange: (money: Int, coins: List[Int])Int

  def sum(money: Int, l: List[Int], denom: List[Int]): Int = {
    var s: Int = 0
    for (i: Int <- l.indices) {
      s = s + l(i) * denom(i)
    }
    s
  }                                               //> sum: (money: Int, l: List[Int], denom: List[Int])Int

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
  }                                               //> change: (money: Int, denom: List[Int])Unit

  def comb(max: Int, size: Int) {
    var counter: List[Int] = List.fill(size)(0)
    for (x <- counter.indices) {
      for (r <- Range(0, max + 1)) {
        def p = counter.updated(x, r)
        println(p)
      }

    }
  }                                               //> comb: (max: Int, size: Int)Unit

 countChange(10,List(2,5))                        //> res0: Int = 2
  change(10, List(1, 1))
  comb(2, 3)                                      //> List(0, 0, 0)
                                                  //| List(1, 0, 0)
                                                  //| List(2, 0, 0)
                                                  //| List(0, 0, 0)
                                                  //| List(0, 1, 0)
                                                  //| List(0, 2, 0)
                                                  //| List(0, 0, 0)
                                                  //| List(0, 0, 1)
                                                  //| List(0, 0, 2)

}