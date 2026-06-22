package bd.edu.aiub.oop.courseproject.repository;

import bd.edu.aiub.oop.courseproject.exception.RepositoryException;
import bd.edu.aiub.oop.courseproject.exception.ValidationException;
import bd.edu.aiub.oop.courseproject.model.CsvConvertible;
import bd.edu.aiub.oop.courseproject.model.Identifiable;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Generic HashMap-backed CSV repository.
 *
 * @param <T> entity type
 */
public abstract class AbstractCsvRepository<T extends Identifiable & CsvConvertible> {
    private final Path filePath;
    private final Map<String, T> storage = new HashMap<>();

    /**
     * Creates repository.
     *
     * @param filePath file path
     */
    public AbstractCsvRepository(Path filePath) {
        if (filePath == null) throw new IllegalArgumentException("File path required.");
        this.filePath = filePath;
    }

    /**
     * Converts CSV row to entity.
     *
     * @param row CSV row
     * @return entity
     * @throws ValidationException when row is invalid
     */
    protected abstract T fromCsv(String row) throws ValidationException;

    /**
     * Saves entity in memory.
     *
     * @param entity entity
     */
    public void save(T entity) {
        if (entity == null) throw new IllegalArgumentException("Entity required.");
        storage.put(entity.getId(), entity);
    }

    /**
     * Finds entity by ID.
     *
     * @param id entity ID
     * @return entity or null
     */
    public T findById(String id) { return storage.get(id); }

    /**
     * Deletes entity by ID.
     *
     * @param id entity ID
     * @return true when deleted
     */
    public boolean deleteById(String id) { return storage.remove(id) != null; }

    /**
     * Lists all entities.
     *
     * @return defensive list
     */
    public List<T> findAll() { return new ArrayList<>(storage.values()); }

    /**
     * Loads entities from file.
     *
     * @throws RepositoryException when loading fails
     */
    public void load() throws RepositoryException {
        storage.clear();
        if (!Files.exists(filePath)) return;
        try (BufferedReader reader = Files.newBufferedReader(filePath)) {
            String row;
            while ((row = reader.readLine()) != null) {
                if (!row.trim().isEmpty()) {
                    T entity = fromCsv(row);
                    storage.put(entity.getId(), entity);
                }
            }
        } catch (IOException | RuntimeException | ValidationException exception) {
            throw new RepositoryException("Could not load " + filePath, exception);
        }
    }

    /**
     * Writes entities to file.
     *
     * @throws RepositoryException when saving fails
     */
    public void flush() throws RepositoryException {
        try {
            Files.createDirectories(filePath.getParent());
            try (BufferedWriter writer = Files.newBufferedWriter(filePath)) {
                for (T entity : storage.values()) {
                    writer.write(entity.toCsv());
                    writer.newLine();
                }
            }
        } catch (IOException exception) {
            throw new RepositoryException("Could not save " + filePath, exception);
        }
    }
}
