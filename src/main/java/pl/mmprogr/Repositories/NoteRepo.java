package pl.mmprogr.Repositories;

import org.springframework.data.repository.CrudRepository;
import pl.mmprogr.Models.Note;

import java.util.List;

/**
 * Created by ggere on 14.03.2017.
 */
public interface NoteRepo extends CrudRepository<Note, Integer> {
    List<Note> findByTitle(String title);
}
