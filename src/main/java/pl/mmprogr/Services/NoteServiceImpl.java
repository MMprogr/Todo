package pl.mmprogr.Services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.mmprogr.Models.Note;
import pl.mmprogr.Repositories.NoteRepo;

import java.util.List;

/**
 * Created by ggere on 14.03.2017.
 */
@Repository
public class NoteServiceImpl implements NoteService {

    private static final Logger logger = LoggerFactory.getLogger(NoteServiceImpl.class);

    @Autowired
    private NoteRepo noteRepo;

    @Override
    @Transactional
    public Note create(Note n) {
        return noteRepo.save(n);
    }

    @Override
    @Transactional
    public Note findById(int id) {
        return noteRepo.findOne(id);
    }

    @Override
    public List<Note> findByTitle(String title) {
        return noteRepo.findByTitle(title);
    }

    @Override
    @Transactional
    public Note delete(int id) {
        Note deletedUser = noteRepo.findOne(id);

        noteRepo.delete(deletedUser);

        return deletedUser;
    }

    @Override
    @Transactional
    public List<Note> findAll() {
        return (List<Note>) noteRepo.findAll();
    }

    @Override
    @Transactional
    public Note update(Note note) {
        Note updatedNote = noteRepo.findOne(note.getId());

        updatedNote.setTitle(note.getTitle());
        updatedNote.setContent(note.getContent());

        return updatedNote;
    }

}
