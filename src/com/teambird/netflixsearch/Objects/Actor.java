package com.teambird.netflixsearch.Objects;

public class Actor {
    private final String Character;
    private final String Actor;

    public Actor(String Character, String Actor) {
        this.Character = Character;
        this.Actor = Actor;
    }

    public String getCharacter() {
        return Character;
    }

    public String getActor() {
        return Actor;
    }

    @Override
    public String toString() {
        return "Actor{" +
                "Character='" + Character + '\'' +
                ", Actor='" + Actor + '\'' +
                '}';
    }
}
