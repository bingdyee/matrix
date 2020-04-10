package io.hikari.labs.gof23.structural.composite;

import java.util.ArrayList;

/**
 * Composite Pattern
 *
 * @author Noa Swartz
 * @date 2018-06-14
 */
public class CompositePattern {

    public static void main(String[] args) {
        Indentation indentation = new Indentation();
        Directory dir1 = new Directory("dir-1", indentation);
        Directory dir2 = new Directory("dir-2", indentation);
        File a = new File("a.file", indentation);
        File b = new File("b.file", indentation);
        File c = new File("c.file", indentation);
        File d = new File("d.file", indentation);
        dir1.add(a);
        dir1.add(dir2);
        dir1.add(b);
        dir2.add(c);
        dir2.add(d);
        dir1.listFiles();
    }

}

class Indentation {
    private StringBuilder sbIndent = new StringBuilder();
    public String getIndentation() {
        return sbIndent.toString();
    }
    public void increaseIndentation() {
        sbIndent.append("-");
    }
    public void decreaseIndentation() {
        if (sbIndent.length() >= 3) {
            sbIndent.setLength(sbIndent.length() - 3);
        }
    }
}

interface IFile {
    void listFiles();
}

class Directory implements IFile {
    private String name;
    private Indentation indentation;
    private ArrayList<IFile> files = new ArrayList<>();
    public Directory (String name, Indentation indentation) {
        this.name = name;
        this.indentation = indentation;
    }
    public void add(IFile file) { files.add(file); }
    @Override
    public void listFiles() {
        System.err.println(indentation.getIndentation() + name);
        indentation.increaseIndentation();
        for (IFile file : files) {
            file.listFiles();
        }
        indentation.decreaseIndentation();
    }
}

class File implements IFile {
    private String name;
    private Indentation indentation;
    public File(String name, Indentation indentation) {
        this.name = name;
        this.indentation = indentation;
    }
    @Override
    public void listFiles() {
        System.err.println(indentation.getIndentation() + name);
    }
}