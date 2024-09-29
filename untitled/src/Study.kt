fun main() {
    print(sum(a = 10, b = 20))
    print(sum(b = 20, a = 10))

    val john = Person("john", 20)
    println(john.name)
    println(john.age)
    //print(john.gender)

    //john.name = "kevin" 불가하게 val로 선언
    john.age = 20

    val john2 = Person("john", 20)
    println(john)
    println(john2)
    println(john == john2)

    val jimin = Developer("student", "C")
    val jimin2 = Developer("student", "C")
    println(jimin == jimin2)
}

// 함수
fun sum(a: Int, b: Int): Int {
    return a + b
}

// 함수 내용이 한 줄이라면 간략하게 표현 가능
fun sum2(a: Int, b: Int) = a + b //(Int + Int = Int로 추론 가능)

fun sum2(a: Int, b: Int, c: Int = 0) = a + b //(Int + Int = Int로 추론 가능)

// 클래스에선 괄호 안에 넣어주면 생성자, getter, setter 다 처리 가능
class Person(
    val name: String,
    var age: Int,
    // private 붙이면 getter 제공 안됨
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Person

        if (name != other.name) return false
        if (age != other.age) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + age
        return result
    }
}
// 굳이 equals와 hashcode를 재정의하지 않아도 클래스 앞에 data 붙이면 됨
data class Developer(
    val name: String,
    val language: String
) {
    var hobby = "축구"
        private set // 외부에서 setter 불가
        get() = "취미 : ${field}" // getter에서는 field라는 걸로 변수 접근

    // 생성자로 파라미터를 받고 후처리가 필요 시
    init {
        println("init")
    }

    fun some() {
        hobby = "잠 자기"
    }
}