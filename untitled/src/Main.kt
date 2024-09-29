import java.util.*
import kotlin.math.max
import kotlin.random.Random

// 탑 레벨 상수 (자바의 final 느낌)
val variable = 20 // 런타임에 초기화됨
const val vairable_2 = 20 // 컴파일 타임에 초기화됨

fun main() {
    println("Hello Kotlin")

    // 코틀린에는 타입을 추론 기능이 있기에 별도로 타입을 지정해주지 않아도 됨
    // 타입 지정 시 {변수명} : {type} 이런식으로 가능
    var number = 10
    var name = "지민"
    var point = 3.3

    // 그리고 코틀린에서는 모든 타입을 객체로 다룸 (원시 타입 int X -> Int O)
    var j_2 : Int = 10
    var name_2 : String = "지민"
    var point_2 : Double = 3.3

    // 상수는 val로 선언
    val num = 20

    // 형 변환
    var i = 10 // Integer
    var l = 20L // Long

    // l = i // 자바에서는 Long에 Integer를 넣을 수 있음
    l = i.toLong() // 코틀린에선 그렇지 않음 (형 변환을 해줘야 함)
    i = l.toInt()

    var letter = "jimini"
    print(letter.uppercase())
    print(letter.lowercase())
    print(letter[0])

    // String Template(= String Interpolation)
    print("제 이름은 " + letter + "입니다")
    print("제 이름은 ${letter} 입니다")


    // 라이브러리 import해서 사용 가능
    var max_1 = 10
    var max_2 = 20
    print(max(max_1, max_2))

    val randomNumber = Random.nextInt(0, 10)
    print(randomNumber)

    // 입력 받기
    val reader = Scanner(System.`in`) // 코틀린에서 사용할 수 없는 키워드이기에 백틱으로 감싸줌
    reader.nextInt()

    // if문
    var test = 5
    if (test > 10) {
        print("10보다 큼")
    } else if (test > 5) {
        print("5보다 큼")
    } else {
        print("")
    }

    // if문은 when문으로 완전히 치환 가능
    when {
        test > 10 -> {
            print("10보다 크다")
        }
        test > 5 -> {
            print("5보다 크다")
        }
        else -> {
            print("")
        }
    }

    // 코틀린에서는 if문을 식으로 취급 가능 (when도 동일)
    var result = if (test > 10) {
        "10 보다 크다"
    } else if (test > 5) {
        "5 보다 크다"
    } else {
        ""
    }

    var result_2 = when {
        test > 10 -> {
            "10 보다 크다"
        }
        test > 5 -> {
            "5 보다 크다"
        }
        else -> {
            ""
        }
    }

    // boolean result_k = k > 10 ? true : false;
    var k = 5
    val result_k = if (k > 10) true else false


    // for문 사용법
    val items = listOf(1, 2, 3, 4, 5)
    for (item in items) {
        print(item)
    }
    // forEach로도 가능
    items.forEach { item ->
        print(item)
    }

    // for (int i = 0; i < items.length; i++)
    for (i in 0..(items.size - 1)) {
        print(items[i])
        break
        continue
        // while도 자바와 완전히 동일
    }

    // 변경이 가능한 리스트
    val changeableList = mutableListOf(1, 2, 3, 4, 5)
    changeableList.add(6)
    changeableList.remove(3)

    // 배열 (잘 안 씀)
    val array = arrayOf(1, 2, 3)
    array.size
    array[0] = 10


    // 예외 처리
    try {
        val indx = array[4]
    } catch (e : Exception) {
        print(e.message)
    }


    // null safety
    var myName : String? = null // null을 대입할 수 있는 타입은 뒤에 ?가 붙어야 함
    myName = "지민"
    myName = null

    var myName2 : String = ""
    if (myName != null) {
        myName2 = myName // String과 String?은 별개의 타입으로 취급됨 -> null check
                         // null check 안에선 String?가 String으로 변환됨
    }
    myName2 = myName!! // !!를 통해 String? -> String

    myName?.let {
        myName2 = myName
    // null이 아니라면 실행 (여기선 it(String)으로 접근됨
    }
}