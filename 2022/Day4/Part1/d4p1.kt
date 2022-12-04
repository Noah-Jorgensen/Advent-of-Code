import java.io.File
 
fun main() {
    val inFile = "input"
    val lines: List<String> = File(inFile).readLines()

    var pairs = 0
    for (item in lines){
        val new = item.split(",")
        val p1 = new[0]
        val p2 = new[1]
        val one_fh = (p1.split("-")[0]).toInt()
        val one_sh = (p1.split("-")[1]).toInt()
        val two_fh = (p2.split("-")[0]).toInt()
        val two_sh = (p2.split("-")[1]).toInt()
        if ((one_fh <= two_fh) && (one_sh >= two_sh)){
            pairs++
        }else if ((one_fh >= two_fh) && (one_sh <= two_sh)){
            pairs++
        }
    }
    println(pairs)
}