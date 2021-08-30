package com.family;

public class Main {

    public static void main(String[] args) {
	// write your code here

        System.out.println("\n\n===== 32197330 SON MYEONG JIN's FAMILY ALGORITHM FOR DesignPattern CLASS =====\n");

        // 남자인 아빠와 여자인 엄마, 그리고 낯선 남자를 생성하였다.
        Person father = new Man("김", "철수", 20);
        Person mother = new Woman("박영희", 26);
        Person stranger = new Man("홍", "길동", 300);

        // 아빠와 엄마는 결혼을 해서 가정을 꾸리게 되었다.
        Family family = Family.getMarried((Man)father, (Woman) mother);
        // 낯선 이는 배우자가 없다.
        stranger.getSpouse();
        // 하지만 아빠 객체는 엄마 객체라는 배우자가 있으며 혼인 관계이다.
        father.getSpouse();
        // 엄마 입장에서 아빠와의 관계는?
        mother.getRelationshipWith(father);
        // 엄마 입장에서 낯선 이와의 관계는?
        mother.getRelationshipWith(new Woman("안인혜", 51));

        // 첫 째 아이 생성. 성별은 무엇일까?
        Person firstChild = family.addChild(((Woman) mother).giveBirth("수민", 16));
        // 첫 아이와 아빠와의 관계는? 아빠 입장에서 첫 아이와의 관계는?
        firstChild.getRelationshipWith(father);
        father.getRelationshipWith(firstChild);

        // 둘 째 아이 생성. 성별은 무엇일까?
        Person secondChild = family.addChild(((Woman) mother).giveBirth("민수", 13));
        // 둘 째 아이와 엄마와의 관계는? 엄마 입장에서 둘 째 아이와의 관계는?
        secondChild.getRelationshipWith(mother);
        mother.getRelationshipWith(secondChild);

        System.out.println();
        // 첫 째 아이는 고양이를 얻었고, 둘 째 아이는 개를 얻었다.
        family.addPet(firstChild.setPet(new Cat()));
        family.addPet(secondChild.setPet(new Dog()));

    }
}
