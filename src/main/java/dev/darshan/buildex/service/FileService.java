package dev.darshan.buildex.service;

import dev.darshan.buildex.dto.project.FileContentResponse;
import dev.darshan.buildex.dto.project.FileNode;
import java.util.List;


public interface FileService {
    List<FileNode> getFileTree(Long projectId, Long userId);

    FileContentResponse getFileContent(Long projectId, String path, Long userId);
}
