package org.hueanalysis.moviediary.models;

import java.util.List;

public class Movie {

    private int id;
    private String title;
    private String original_title;
    private String overview;
    private String poster_path;
    private String backdrop_path;
    private String studio;
    private String rating;
    private String streamimgLink;
    private String language;
    private String release_date;
    private double vote_average;
    private int vote_count;
    private int popularity;
    private List genre_ids[];
    private boolean adult;
    private boolean video;

    private static final String POSTER_THUMB_BASE_URL = "https://image.tmdb.org/t/p/w440_and_h660_face";
    private static final String BACKGROUND_BASE_URL = "https://image.tmdb.org/t/p/w500_and_h282_face";


    public static  Movie[] MOVIES = new Movie[] {

        new Movie(419704, "애드 아스트라", 9.3, "Ad Astra",  "/37M8j1nwMs8wu2H2tMtDjqhTSnd.jpg", "/5BwqwxMEjeFtdknRV792Svo0K1v.jpg","희망과 갈등이 공존하는 가까운 미래. 미 육군 소령 '로이 맥브라이드'는 우주의 지적생명체를 찾기 위한 '리마 프로젝트'를 수행중에 실종된 아버지를 영웅이라 믿으며 우주 비행사의 꿈을 키웠다. 어느 날, '로이'는 이상 현상으로 우주 안테나에서 지구로 추락하는 사고를 당하고 인류를 위협할 전류 급증 현상인 '서지'가 자신의 아버지 '클리프 맥브라이드'가 벌인 위험한 실험에서 시작되었다는 이야기를 듣게된다. 아버지가 살아 있다는 충격적인 진실과 함께 그를 막아야 한다는 임무를 맡은 '로이'는 우주로 향하게 되는데…"),
        new Movie(339095, "라스트 데이스 오브 아메리칸 크라임", 7.5, "The Last Days of American Crime", "/ygCQnDEqUEIamBpdQdDYnFfxvgM.jpg", "/t93doi7EzoqLFckidrGGnukFPwd.jpg", "일주일 후면 신호가 켜진다. 범죄 발생을 막기 위해, 개인의 머릿속을 통제하려는 정부. 자유가 사라지기 전에, 베테랑 은행 강도가 일생일대의 마지막 범죄를 계획한다."),
        new Movie(454626, "수퍼 소닉", 8.7,"Sonic the Hedgehog", "/pMXOlasWr1IzHGH8HWw1ZTXs6rQ.jpg", "/stmYfCUGd8Iy6kAMBr6AmWqx8Bq.jpg","소리보다 빠른 초고속 고슴도치 히어로 '소닉'은 지구에 불시착한다. 그의 특별한 능력을 감지한 과학자 ‘닥터 로보트닉’은 세계 정복의 야욕을 채우려 하고, 경찰관 ‘톰’은 위험에 빠진 ‘소닉’을 돕기 위해 나서는데…! 과연, ‘소닉'은 천재 악당에 맞서 지구를 지킬 수 있을까?"),
        new Movie(574982, "블랙아웃 : 인베이젼 어스",6.8, "Аванпост", "/2sWmX2mqhPOCEtFteX5pC7dZYPk.jpg", "/4phMeITqEnShF5C3ZD0Q8YQFMAB.jpg", "원인 모를 방사능에 노출된 인류는 0.5% 생존하게 되었고, 그것이 외계인의 침공과 연관 있음을 알게 되는데.."),
        new Movie(496243, "기생충",8.5, "기생충","/jKZYyrqeLt4wUzs8rE4tqRfDeCm.jpg", "/ApiBzeaa95TNYliSbQ8pJv4Fje7.jpg", "전원 백수로 살 길 막막하지만 사이는 좋은 기택(송강호) 가족. 장남 기우(최우식)에게 명문대생 친구가 연결시켜 준 고액 과외 자리는 모처럼 싹튼 고정수입의 희망이다. 온 가족의 도움과 기대 속에 박 사장(이선균) 집으로 향하는 기우. 글로벌 IT기업의 CEO인 박 사장의 저택에 도착하자 젊고 아름다운 사모님 연교(조여정)와 가정부 충숙(장혜진)이 기우를 맞이한다. 큰 문제 없이 박 사장의 딸 다혜(정지소)의 과외를 시작한 기우. 그러나 이렇게 시작된 두 가족의 만남 뒤로, 걷잡을 수 없는 사건이 기다리고 있는데..."),
        new Movie(429617, "스파이더맨: 파 프롬 홈", 8.8,"Spider-Man: Far from Home","/742vR63T1AcXzYwHypQpzZd89vh.jpg","/5myQbDzw3l8K9yofUXRJ4UTVgam.jpg","어벤져스 멤버들과 타노스와의 대접전을 마친 뒤, 지난 5년 동안 사라졌던 사람들이 동시에 돌아왔다. 아이언맨이 떠난 채 한동안 지구를 구할 히어로가 공석인 상황을 수습할 히어로는 현재 스파이더맨 피터 파커(톰 홀랜드)뿐이다. 친구들과의 유럽 현장학습 도중 닉 퓨리(새뮤얼 L. 잭슨)의 부름을 받게 된 피터는 미스테리오(제이크 질렌홀)라는 정체 모를 히어로와 힘을 합쳐 엘리멘탈이라는 괴생명체를 무찔러야 하는 상황에 처한다. 그런데 피터는 지구를 구하는 일보다 MJ(젠다야 콜먼)에게 멋지게 고백할 계획이 우선인데..."),
        new Movie(338762, "블러드샷",7.9,"Bloodshot","/5S45aZzCo6rIeE8zLsffi5lCYz6.jpg","/ocUrMYbdjknu2TwzMHKT9PBBQRw.jpg","아내와 함께 휴가를 보내던 특수 부대원 ‘레이’(빈 디젤)는 정체불명의 적에게 납치되어 살해당한다. 혈액 속에 수많은 나노봇을 주입하는 최첨단 프로젝트 블러드샷을 통해 부활한 레이. 놀라운 치유력과 가공할 만한 파워의 슈퍼 히어로로 업그레이드된 레이는 아내를 죽인 놈을 찾아 무차별적인 복수의 질주를 시작한다. 하지만, 자신이 진짜라고 생각했던 것들이 거짓임을 깨닫게 되는데… 복수의 시작, 액션의 끝! 2020년 액션 블록버스터의 최종 진화를 확인하라!"),
        new Movie(514847, "헌트",8.3,"The Hunt","/8mS3VvzeDfw6VdgQQbXsunNBEit.jpg","/naXUDz0VGK7aaPlEpsuYW8kNVsr.jpg","낯선 사람들과 함께 의문의 지역에 갇혀 영문도 모른 채 사냥 당하고 있는 ‘크리스탈’(베티 길핀)이 자신들을 사냥하는 주체를 밝히고, 그들을 찾아 복수하기 위해 고군분투하는 이야기")
    };


    public Movie(int id, String title, double vote_average, String original_title, String poster_path, String backdrop_path, String overview) {
        this.id = id;
        this.title = title;
        this.original_title = original_title;
        this.poster_path = poster_path;
        this.backdrop_path = backdrop_path;
        this.overview = overview;
        this.vote_average = vote_average;
    }

    public Movie() {

    }


    public static Movie getMovie(int mId){
        for (Movie movie : MOVIES){
            if(movie.getMovieId() == mId){
                return movie;
            }
        }
        return null;
    }

    private int getMovieId() {
        return this.id;
    }

    public Movie getItem(int position) {
        return Movie.MOVIES[position];
    }

    public int getId() {
        return this.id;
    }

    public String getTitle() {
        return title;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public String getOverview() {
        return overview;
    }

    public String getPoster_path() {
        return POSTER_THUMB_BASE_URL + poster_path;
    }

    public String getBackdrop_path() {
        return BACKGROUND_BASE_URL + backdrop_path;
    }

    public double getVote_average() {
        return this.vote_average;
    }

    public int size(){
        return MOVIES.length;
    }


}
