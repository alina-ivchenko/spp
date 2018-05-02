package main.java.View;

import main.java.Abiturient;

import java.util.List;

public interface IReportView {
    byte[] generateReportByAbiturients(List<Abiturient> crimes);
}
