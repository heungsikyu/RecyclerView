package org.hueanalysis.moviediary.models;

public class CastingModel {


    int id;
    int cast_id;
    String character;
    String credit_id;
    int gender;
    String name;
    int order ;
    String profile_path;



    private static final String PROFILE_BASE_URL = "https://image.tmdb.org/t/p/w276_and_h350_face";


    public CastingModel(int id, String character, String credit_id, int gender, String name, int order, String profile_path) {
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
