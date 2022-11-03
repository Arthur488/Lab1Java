package uacnstucore;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class PluginClassLoader extends ClassLoader {
    private String jarName;
    private JarFile jar;
    private Map <String, Class <?>> loaded = new HashMap <String, Class <?>>();

    public PluginClassLoader(String jarName) {
        super(PluginClassLoader.class.getClassLoader());
        this.jarName = jarName;
        try {
            this.jar = new JarFile(jarName);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public Class<?> findClass(String name) throws ClassNotFoundException {
        Class<?> clazz = loaded.get(name);
        if (clazz != null)
            return clazz;
        try {
            return findSystemClass(name);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        byte[] data;
        try {
            data = loadClassData(name);
            clazz = defineClass(name, data, 0, data.length);
            loaded.put(name, clazz);
        } catch (Throwable ex) {
            throw new ClassNotFoundException(ex.getMessage());
        }
        return clazz;
    }
    private byte[] loadClassData(String name) throws ClassNotFoundException {
        String entryName = name.replace('.', '/') + ".class";
        byte buf[] = new byte[0];
        try {
            JarEntry entry = jar.getJarEntry(entryName);
            if (entry == null) {
                throw new ClassNotFoundException(name);
            }
            InputStream input = jar.getInputStream(entry);
            int size = Long.valueOf(entry.getSize()).intValue();
            buf = new byte[size];
            int count = input.read(buf);
            if (count < size)
                throw new ClassNotFoundException("Error reading class " + name +
                        " from :" + jarName);
        } catch (IOException ex) {
            throw new ClassNotFoundException(ex.getMessage());
        }
        return buf;

    }
}

