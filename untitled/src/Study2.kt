fun main() {
    val dog: Animal = Dog()
    val cat = Cat()

    // 타입 체크
    if (dog is Dog) {
        // 여길 통과했기에 Dog의 매서드 사용 가능
        println("멍멍이")
    }
    if (dog is Cat) {
        println("멍멍이?")
    }

    // 강제 캐스팅 가능
    cat as Dog // 여기선 에러 날거임
}

interface Drawable {
    fun draw()
}

// 자바에서는 모든게 열려있는 반면, 코틀린에서는 모든게 닫혀있음

abstract class Animal {
    open fun move() { // child에서 오버라이딩이 가능하기 위해선 open 선언
        print("이동")
    }
}

class Dog(): Animal(), Drawable {
    override fun move() {
        println("찹찹")
    }

    override fun draw() {
        TODO("Not yet implemented")
    }
}

class Cat(): Animal() {
    override fun move() {
        println("살금")
    }
}

open class Human() // 일반 클래스는 상속 불가
                   // -> open 붙여주기 (open class는 abstract와 달리 모든 매서드 오버라이딩 필요 X)

class SuperMan: Human()
