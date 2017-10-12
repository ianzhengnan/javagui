package com.ian.io.ext;

import java.io.File;
import java.io.IOException;

/**
 * 提供此接口，为了将来有多种实现
 */
public interface HandleDirFile {

    void cd();

    void copy(String sourcePath, String targetPath) throws IOException;

    void deepCopy(File file, String targetPath) throws IOException;

    void move(String sourcePath, String targetPath) throws IOException;

    void deleteFile(File file) throws IOException;
}
