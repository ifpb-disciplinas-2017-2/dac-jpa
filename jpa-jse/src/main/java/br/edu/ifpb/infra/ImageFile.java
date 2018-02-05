package br.edu.ifpb.infra;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 30/01/2018, 07:48:57
 */
public class ImageFile {

    private Path path;

    public ImageFile() {
        this("");
    }

    public ImageFile(String string) {
        this(Paths.get(string));
    }

    public ImageFile(Path path) {
        this.path = path;
    }

    public byte[] toBytes() {
        try {
            return Files.readAllBytes(path);
        } catch (IOException ex) {
            Logger.getLogger(ImageFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new byte[0];
    }

}
