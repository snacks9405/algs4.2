public class Request {
    int id;
    int cost;
    int deadline;

    Request(int id, int cost, int deadline) {
        this.id=id;
        this.cost=cost;
        this.deadline=deadline;
    }
    @Override
    public String toString() {
        String string = id + " " + cost + " " + deadline;
        return string;
    }
}
