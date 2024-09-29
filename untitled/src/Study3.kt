import javax.security.auth.callback.Callback

fun main() {
    val box = Box<Int>(10) //타입 추론되기에 타입 선언 안해도 됨
    val box2 = Box("lkj")

    print(box2.value)

    // 코틀린에서 전달하는 인자가 함수인 경우, 함수를 밖으로 뺄 수 있음
    myFunc(10) { println("함수 호출") }
    // 전달 인자가 함수 하나인 경우 괄호도 생략 가능
    myFunc { println("함수 호출") }

}

// Generic 타입
class Box<T>(val value: T) {
}

// Void란 건 없음 -> Unit 존재
fun myFunc(a: Int = 0, callback: () -> Unit) {
    callback()
}

