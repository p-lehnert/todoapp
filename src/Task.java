public class Task {

    private String text;

    private boolean done;

    public Task (final String text) {
        this.text = text;
        done = false;
    }

    public void setText(final String editedText) {
        text = editedText;
    }

    public String getText() {
        return text;
    }

    public void setDone(final boolean action) {
        done = action;
    }

    public boolean isDone() {
        return done;
    }
}
