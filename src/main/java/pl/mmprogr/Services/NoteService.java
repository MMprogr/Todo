package pl.mmprogr.Services;

import pl.mmprogr.Models.Note;

import java.util.List;

/**
 * Created by ggere on 14.03.2017.
 */
public interface NoteService {
    public Note create(Note n);

    public Note delete(int id);

    public List<Note> findAll();

    public Note update(Note n);

    public Note findById(int id);

    public List<Note> findByTitle(String title);
}
