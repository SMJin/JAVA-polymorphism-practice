# JAVA-polymorphism-practice

### 32197330 손명진의 Design Pattern 강의에 대한 자바 상속, 다형성 과제 코드입니다.

## < 문제 >

###### 남자와 여자가 결혼을 하여 자식을 가지는 프로그램을 작성하고자 한다.
###### 남자와 여자는 이름과 나이를 가지고 결혼을 할 수 있으며 애완동물을 가질 수 있다.
###### 여자는 출산을 할 수 있다. 출산 자녀의 성별은 랜덤으로 주어진다.
###### 두 사람의 혼인 관계를 확인 할 수 있는 방법을 가져야한다.
###### 두 사람의 자식 부모관계를 확인 할 수 있으며 자식 관계인 경우 아들인지 딸인지, 아빠인지 엄마인지를
###### 구분하는 방법을 가져야 한다.
###### 애완 동물은 개와 고양이 두 종류이고 개는 '멍멍'하고 소리를 내며 고양이는 '야옹'하고 소리를 낸다.

###### 위 요건을 만족하는 프로그램을 작성하고 다음 흐름을 프로그램으로 작성하시오
###### 남자와 여자를 생성하고 결혼을 시킨 후 출산을 2번 한다.
###### 가족 집단을 크기 가변형 collection으로 표현한다.
###### 아빠와 자녀의 관계가 아들인지 딸인지를 춣력한다.
###### 첫번째 자녀는 개를 애완동물로 가지며 두번째 자녀는 고양이를 애완 동물로 가진다.
###### 가족 전체의 애완동물이 어떤 소리를 내는 지 출력한다.

###### 충족해야할 기술
###### 1. 상속이 이용되어야 한다.
###### 2. 다형성이 이용되어야 한다.
###### 3. 자바의 collection 구조가 이용되어야 한다.

## < 파일 구조 설명 >

### family-package 와 family2-package 두 폴더가 있는 이유는 주어진 한 문제에 대해서 두 가지 방식으로 풀었기 때문이다.

##### family-package
###### 한 사람에 배정된 관계를 Person Class 에 정의했다.

##### family2-package
###### 한 사람에 배정된 관계를 Family Class 에 정의했다.

##### 두 패키지 코드의 공통된 부분
###### Cat Class 와 Dog Class 는 Pet interface 를 따른(implements)다.
###### Woman Class 와 Man Class 는 추상 클래스인 abstract Person Class 를 상속(extends)한다.

##### 다형성 충족
```java
Pet pet = new Cat(firstChild);
System.out.println("pet이 고양이로 정의될 때 : " + pet.getHowling());
pet = new Dog(secondChild);
System.out.println("pet이 강아지로 정의될 때 : " + pet.getHowling());
```
###### 위 코드의 결괏값은 다음과 같다.
######
###### pet이 고양이로 정의될 때 : 야옹
###### pet이 강아지로 정의될 때 : 멍멍
######
###### Pet interface 는 Cat Class 와 Dog Class 의 사용 방법을 정의한 것이므로 Cat 객체와 Dog 객체의 교환성을 높여주며 이는 다형성의 핵심이다. 같은 pet interface 를 따르며 호출되었지만, 어떤 동물 개체를 넣느냐에 따라서 결과가 달라지기 때문이다.

```java
// 남자인 아빠와 여자인 엄마, 그리고 낯선 남자를 생성하였다.
Person father = new Man("김", "철수", 20);
Person mother = new Woman("박영희", 26);
Person stranger = new Man("홍", "길동", 300);
```
###### 또 Person abstract class 의 경우, 부모 클래스로의 타입 변환 또한 허용한다. 바로 위 코드에서 왼 편은 Person 이지만 오른 편에서는 Man 과 Woman Class 가 둘다 허용된다는 점이 바로 그 점이다. 같은 타입으로 정의되더라도 실행 결과는 다른 객체를 이용하는 성질이 바로 다형성이다.

```java
public class Family {
private Woman mother;
private Man father;
private ArrayList<Person> children;
private ArrayList<Pet> pets;
```
###### Family Class 에서 가족집단 ArrayList 와 pet ArrayList 에서도 보면 각각은 Person 타입과 Pet 타입으로 지정되어 있다. 그러나 Person 타입으로 정의된 children Arraylist 에는 Man class 와 Woman class 모두 들어갈 수 있다. pet 타입으로 정의된 pets Arraylist 또한 마찬가지이다. 여기에는 Cat class 와 Dog class 모두 들어갈 수 있다. 그러니까, Person 은 Man 또는 Woman 이 될 수있고 Pet 은 Cat 혹은 Dog 가 될 수 있다 하는 여지를 남겨두는 것이다.

###### 이런 개념에서, 상속 또한 다형성의 한 형태라고 생각한다. 특히 Overriding 을 이용해서 다양한 형태로 메소드가 재정의 되는 부분이 다형성의 특징을 가장 크게 보여준다.

###### 이런 반면, Man class 가 받지 못하는 메소드도 있다. 그건 바로 giveBirthTo 메소드이다. (추상클래스가 아니게 되어서 객체를 만들 수 있게 되어도) Person 클래스 또한 해당 메소드는 받지 못할 것이다. 그 이유는 giveBirthTo (아이를 낳는) 메소드는 Woman class 만의 메소드이기 때문이다. 이처럼 Man class 과 Woman class 모두 Person 클래스를 받는다고 할 지라도 각 고유의 특성있는 메소드는 건드리지 못한다. 이 또한 다형성과 상당히 밀접한 연관을 지닌다고 생각한다. 다형성을 사용해서 같은 타입이더라도 다양한 형태를 보장하지만, 또 각 객체의 고유한 특징 또한 살릴 수 있다.