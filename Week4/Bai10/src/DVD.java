public class DVD extends MediaItem {
    private String director;
    private int durationMinutes;

    public DVD(String id, String name, String director, int durationMinutes) {
        super(id, name);
        this.director = director;
        this.durationMinutes = durationMinutes;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public void setDurationMinutes(int durationMinutes) {
        this.durationMinutes = durationMinutes;
    }

    @Override
    public String toString() {
        return getName() + " - " + director + " - " + durationMinutes + " phut";
    }
}
