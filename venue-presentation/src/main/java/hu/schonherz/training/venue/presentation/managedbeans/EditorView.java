package hu.schonherz.training.venue.presentation.managedbeans;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class EditorView {

    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
