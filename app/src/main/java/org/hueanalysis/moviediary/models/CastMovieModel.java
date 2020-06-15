package org.hueanalysis.moviediary.models;

public class CastMovieModel {


    int id;
    int cast_id;
    String character;
    String credit_id;
    int gender;
    String name;
    int order ;
    String profile_path;



    private static final String PROFILE_BASE_URL = "https://image.tmdb.org/t/p/w276_and_h350_face";

    public static  CastMovieModel[] CASTS = new CastMovieModel[] {

            new CastMovieModel(20738, "Kim Ki-taek", "5a4db31fc3a3683b82003a00", 2,  "Song Kang-ho", 0,"/714R0wEx5SJ9o7l1Zfs37jTc8hi.jpg"),
            new CastMovieModel(115290, "Park Dong-ik", "5bcf34f9c3a3686637014df3", 2,  "Lee Sun-kyun", 1,"/nnwVLKIQPYoF88ohshnFfbSB0UW.jpg"),
            new CastMovieModel(556435, "Yeon-kyo", "5bcf351f92514172df0118e1", 1,  "Cho Yeo-jeong", 2,"/5MgWM8pkUiYkj9MEaEpO0Ir1FD9.jpg"),
            new CastMovieModel(1255881, "Ki-woo", "5a4db31fc3a3683b82003a00", 2,  "Choi Woo-shik", 3,"/hfskkkziJrGwobqik02RSoyt6v0.jpg"),
            new CastMovieModel(1442583, "Ki-jung", "5bcf359b0e0a26624f012c00", 1,  "Park So-dam", 4,"/uWppIvypWODMjCxiGDWX92y86ci.jpg"),
    };

    public CastMovieModel(int id, String character, String credit_id, int gender, String name, int order, String profile_path) {
        this.id = id;
        this.character = character;
        this.credit_id = credit_id;
        this.gender = gender;
        this.name = name;
        this.order = order;
        this.profile_path = profile_path;
    }


    public int getId() {
        return id;
    }

    public int getCast_id() {
        return cast_id;
    }

    public String getCharacter() {
        return character;
    }

    public String getCredit_id() {
        return credit_id;
    }

    public int getGender() {
        return gender;
    }

    public String getName() {
        return name;
    }

    public int getOrder() {
        return order;
    }

    public String getProfile_path() {
        return PROFILE_BASE_URL + profile_path;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setCast_id(int cast_id) {
        this.cast_id = cast_id;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public void setCredit_id(String credit_id) {
        this.credit_id = credit_id;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public void setProfile_path(String profile_path) {
        this.profile_path = profile_path;
    }
}
