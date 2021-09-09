import java.util.*
import kotlin.math.abs
fun main(args: Array<String>) {



    //Question1()
    //Question2()
    //Question4()

}


fun Question1(){
    print("Input: s = ")
    var s:String= readLine().toString()
    print("Input: p = ")
    var p:String= readLine().toString()
    var realPattern=""
    for(c in p){
        if(c=='*'){
            realPattern+="[a-z]*"
        }
        else if(c=='?'){
            realPattern+="[a-z]"
        }
        else{
            realPattern+=c
        }
    }
    if(s.matches(realPattern.toRegex())) {
        print("Output: "+true)
    }
    else{
        print("Output: "+false)
    }
}

fun Question2(){

    print("Input: ")
    var s:String= readLine().toString()
    s=s.replace("(","")
    s=s.replace(")","")
    s=s.replace(" ","")

    var output:Int=s[0].digitToInt()
    for(i in 1 .. s.count()-1 step 2){
        if(s[i].equals('+')){
            output+=s[i+1].digitToInt()
        }
        else{
            output-=s[i+1].digitToInt()
        }
    }
    print("Output: "+output)
}

fun Question4(){
    print("Please Enter the mxn matrix, Rows:  ")
    var numRows= readLine()!!.toInt()
    print("Coulmns: ")
    var numCols= readLine()!!.toInt()
    var myMatrix = Array(numRows) { IntArray(numCols) }
    println("Please enter the Dungeon in form of matrix")
    myMatrix=readIntArray2d(numRows,numCols)

    var accum=myMatrix[0][0];
    var i=0
    var j=0
    while(i!=numRows-1 || j !=numCols-1){

        if(j==numCols-1){
            i+=1
            accum+=myMatrix[i][j]
        }
        else if(i==numRows-1){
            j+=1
            accum+=myMatrix[i][j]
        }
        else if(myMatrix[i][j+1]>=myMatrix[i+1][j]){
            j+=1
            accum+=myMatrix[i][j]
        }
        else if(myMatrix[i][j+1]<=myMatrix[i+1][j]){
            i+=1
            accum+=myMatrix[i][j]
        }
    }
    accum= abs(accum)+1
    println("Output : $accum")

}


private fun readln() = readLine()!!
private fun readlnStrings() = readln().split(' ')
private fun readIntArray() = readlnStrings().run { IntArray(size) { get(it).toInt() } }
private fun readIntArray2d(rows: Int, cols: Int) = Array(rows) { readIntArray().also { require(it.size == cols) } }
