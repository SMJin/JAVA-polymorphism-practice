package com.family2;

import com.family2.Cat;
import com.family2.Dog;
import com.family2.Family;
import com.family2.Man;
import com.family2.Person;
import com.family2.Woman;

public class Main {

    public static void main(String[] args) {
	// write your code here

        System.out.println("\n\n===== 32197330 SON MYEONG JIN's FAMILY2 ALGORITHM FOR DesignPattern CLASS =====\n");

        // 남자인 아빠와 여자인 엄마, 그리고 낯선 남자를 생성하였다.
        Man father = new Man("최", "길남", 20);
        Woman mother = new Woman("박", "인자", 26);
        Person stranger = new Man("홍", "길동", 300);
        // 아빠와 엄마는 결혼을 해서 가정을 꾸리게 되었다.
        Family family = Family.getMarried(father, mother);

        // 아빠와 엄마의 관계는 무엇일까?
        family.isMarried(father, mother);
        // 홍길동씨는 엄마랑 무슨 사이야?
        family.isMarried((Man) stranger, mother);

        // 첫 째 아이 생성. 성별은 무엇일까?
        Person firstChild = family.addChild("일산", 16);
        // 둘 째 아이 생성. 성별은 무엇일까?
        Person secondChild = family.addChild("두산", 13);

        // 아빠와 첫 째 아이와의 관계는?
        family.isParentChild(father, firstChild);
        // 아빠와 둘 째 아이와의 관계는?
        family.isParentChild(father, secondChild);

        System.out.println();
        // 첫 째 아이는 고양이를 얻었고, 둘 째 아이는 개를 얻었다.
        family.addPet(new Cat(firstChild));
        family.addPet(new Dog(secondChild));

        Pet pet = new Cat(firstChild);
        System.out.println("pet이 고양이로 정의될 때 : " + pet.getHowling());
        pet = new Dog(secondChild);
        System.out.println("pet이 강아지로 정의될 때 : " + pet.getHowling());

    }
}
