package me.whiteship.inflearnthejavatest;

import org.junit.jupiter.api.*;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

// 해당 클래스에 있는 모든 메소드들의 적용(메소드에만 적용 가능)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class) // 언더스코어 "_" 를 공백으로 바꿔준다.
class StudyTest {
        // 스프링부트 2.2부터는 스프링부트 스타터가 제공하는 기본 junit의존성이 5점대로 바뀜

    @Test
    @DisplayName("스터디 만들기1") // 권장

    void create_new_study() {
        Study actual = new Study(10);
        assertThat(actual.getLimit()).isGreaterThan(0); //getLimit()가 0 보다 크냐.. assertJ 구문문





        // 우리가 실행하는 코드가 특정한 시간 이내에 반드시 완료 해야 하는 경우 테스트
        // duration 얼마 안에 끝내야 하는지, 어떤걸 할 때
//        assertTimeout(Duration.ofMillis(100), ()-> {
//            new Study(10);
//            Thread.sleep(300);
//        });
//
//        IllegalArgumentException exception =
//                assertThrows(IllegalArgumentException.class, ()-> new Study(-10)); // 이코드를 실행할 때 예외가 발생하는지 테스트
//        String message = exception.getMessage(); // 메세지를 꺼내서
//
//        // 이 메세지가 내가 기대했던 메세지가 같은지
//        assertEquals("limit은 0보다 커야 한다.", exception.getMessage());

//        Study study = new Study(-10);
//        assertNotNull(study); // 스터디라는 인스턴스가 null이 아닌지

//        // Study를 처음 만들면 상태가 DRAFT
//        // 기대하는 값, 실제 나오는 값, 에러메세지
//        assertEquals(StudyStatus.DRAFT, study.getStatus(),"스터디를 처음 만들면 상태값이 DRAFT여야 한다.");
//
//        //limit이 0이 아니여야 한다.
//        assertTrue(study.getLimit() > 0, "스터디 최대 참석 가능 인원은 0보다 커야 한다.");

        //위 세개 assert 문중에 하나가 에러가 나면 다음 것이 에러 낫는지 안낫는지 확인하기 어렵다.
        // 한번에 보려면 assertAll() 사용
//        assertAll(
//                () -> assertNotNull(study),
//                () -> assertEquals(StudyStatus.DRAFT, study.getStatus(),
//                        () -> "스터디 처음  만들면" + StudyStatus.DRAFT + " 상태다."),
//                () -> assertTrue(study.getLimit()>0, "스터디 최대 참석 가능 인원은 0보다 커야 한다.")
//        );


    }

    @Test
//    @Disabled // Test 하고싶지 않을 때
    void create_new_study_again(){
        System.out.println("create1");
    }

    // 위에있는 모든 테스트 실행 전에 반드시 한번만 호출 되고
    @BeforeAll
    static void beforeAll(){ // 반드시 static 메소드 사용해야 함 private 안됨, default됨, return Type 없어야함, static void로 사용
        System.out.println("before all");
    }

    // 모든 테스트가 실행 된 이후 한번만 호출
    @AfterAll
    static void afterAll(){
        System.out.println("after all");
    }

    // 각각 테스트를 실행하기 이전 호출
   @BeforeEach
    void beforeEach(){
       System.out.println("before each");
   }

   @AfterEach
    void afterEach(){
       System.out.println("After each");
   }
}