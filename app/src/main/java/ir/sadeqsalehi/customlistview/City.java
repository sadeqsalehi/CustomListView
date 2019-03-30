package ir.sadeqsalehi.customlistview;

public class City {
    private String name;
    private int population;
    private int id; //images res id

    public City(String name, int population, int id) {
        this.name = name;
        this.population = population;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return name;
    }
}
