package com.QLK.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.testng.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import javax.swing.JButton;
import javax.swing.JTextField;

import org.junit.Before;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.QLK.dao.NhaCungCapDAO;
import com.QLK.entity.NhaCungCap;
import com.QLK.view.ThongTinNhaCungCapJPanel;

public class NCCTest {
	

	 private ThongTinNhaCungCapJPanel panel;
    @Before
    public void setUp() {
    	panel = new ThongTinNhaCungCapJPanel();
    }
	@Test
	public void testCheckInserted1() {
	    NhaCungCapDAO nhaCungCapDAO = new NhaCungCapDAO();
	    NhaCungCap nhaCungCap = new NhaCungCap("", "", "", "", "");
	    boolean result = nhaCungCapDAO.checkInserted(nhaCungCap);
	    Assert.assertFalse(result);
	}
	
	@Test
	public void testCheckInsertedWithEmptyTenNCC() {
	    NhaCungCapDAO nhaCungCapDAO = new NhaCungCapDAO();
	    NhaCungCap nhaCungCap = new NhaCungCap("NC0013", "", "0347986261", "mail@gmail.com", "Quan 10"); 
	    boolean result = nhaCungCapDAO.checkInserted(nhaCungCap);
	    Assert.assertFalse(result);
	}
	
	@Test
	public void testCheckInsertedWithInvalidEmail() {
	    NhaCungCapDAO nhaCungCapDAO = new NhaCungCapDAO();
	    NhaCungCap nhaCungCap = new NhaCungCap("NC0013", "Huu Phat", "0347986261", "mailgl.com", "Quan 10"); 
	    boolean result = nhaCungCapDAO.checkInserted(nhaCungCap);
	    Assert.assertFalse(result);
	}
	
	@Test
	public void testDelete() {
	    NhaCungCap ncc = new NhaCungCap("NCC00013", "Nhà cung cấp 13", "0123456789", "ncc13@gmail.com", "Địa chỉ tào lao");
	    NhaCungCapDAO nhaCungCapDAO = new NhaCungCapDAO(); 
	    nhaCungCapDAO.insert(ncc); 
	    NhaCungCap insertedNCC = nhaCungCapDAO.selectById("NCC00013");
	    assertNotNull(insertedNCC);
	    nhaCungCapDAO.delete("NCC00013");
	    NhaCungCap deletedNCC = nhaCungCapDAO.selectById("NCC00013");
	    assertNull(deletedNCC);
	}
	
	@Test
    public void testClearForm() {
		ThongTinNhaCungCapJPanel panel = new ThongTinNhaCungCapJPanel();

		panel.clearForm();

		assert(panel.txtMaNCC.getText().equals(""));
        
    }




	

}
