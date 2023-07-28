package com.QLK.test;

import com.QLK.dao.DonViDAO;
import com.QLK.entity.DonVi;
import com.QLK.entity.TonKho;
import com.QLK.view.TraCuuHangHoaJPanel;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TonKhoTest {
    private DonViDAO DonViDAO;
    private TraCuuHangHoaJPanel traCuuHangHoaJPanel;
    private JButton btnAll;
    private JTable tblTonKho;

    @Before
    public void setUp() {
    	DonViDAO = new DonViDAO();
    	traCuuHangHoaJPanel = new TraCuuHangHoaJPanel();
        JTable tblTonKho = new JTable();
        DefaultTableModel model = new DefaultTableModel();
        tblTonKho.setModel(model);
        String[] rowData = {"MacBook"};
        model.addRow(rowData);
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        tblTonKho.setRowSorter(sorter);
    }

    @Test
    public void testComboBoxValues() {
        List<DonVi> DonViList = DonViDAO.selectAll();
        assertEquals(3, DonViList.size());
        List<String> comboBoxValues = DonViDAO.getComboBoxValues(DonViList); 
        assertEquals(3, comboBoxValues.size());
        assertTrue(comboBoxValues.contains("Kho hàng số 1"));
        assertTrue(comboBoxValues.contains("Kho hàng số 2"));
        assertTrue(comboBoxValues.contains("Kho hàng số 3"));
    }
    
    @Test
    public void testSearch() {
    	JTextField txtSearch = traCuuHangHoaJPanel.txtSearch;
        txtSearch.setText("MacBook");

        traCuuHangHoaJPanel.searchOn();

        JTable tblTonKho = traCuuHangHoaJPanel.getTblTonKho();
        int rowCount = tblTonKho.getRowCount();

        assertEquals(1, rowCount);

    }
    
    @Test
    public void testBtnAll() {
        JButton btnAll = traCuuHangHoaJPanel.btnAll;

        btnAll.doClick();
        JTable tblTonKho = traCuuHangHoaJPanel.getTblTonKho();
        int rowCount = tblTonKho.getRowCount();
        assertEquals(7, rowCount);
    }

}
