package org.example.input;

public interface DataInput {
    String getConnectionString();
    String getSecret();
    int getInt(String prompt);
    String getString(String prompt);
}
