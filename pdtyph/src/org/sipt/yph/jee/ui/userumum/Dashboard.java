package org.sipt.yph.jee.ui.userumum;

import java.io.File;
import java.util.List;

import org.pdtyph.entity.Instansi;
import org.yph.jee.persistence.GenericPersistence;

import com.vaadin.data.util.BeanContainer;
import com.vaadin.data.util.BeanItem;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FileResource;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.Responsive;
import com.vaadin.server.VaadinService;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Table;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Table.ColumnGenerator;
import com.vaadin.ui.themes.ValoTheme;

public class Dashboard extends HorizontalSplitPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8265667895917038873L;
	private Label titleLabel;

	public Dashboard() {
		addStyleName(ValoTheme.PANEL_BORDERLESS);
		setFirstComponent(rightComponent());
		setSecondComponent(buildHeader());
		setSplitPosition(20);

	}
	private Component buildHeader() {
		VerticalLayout header = new VerticalLayout();
		header.addStyleName("viewheader");
		header.setSpacing(true);
		String basepath = VaadinService.getCurrent()
				.getBaseDirectory().getAbsolutePath();
		FileResource resource = new FileResource(new File(basepath +"/WEB-INF/img/birul.jpeg"));
		titleLabel = new Label("SELAMAT DATANG PADA SISTEM PANGKALAN TUGAS (DOSEN, GURU DAN KARYAWAN YPH PPD NW PANCOR");
		Label gambar=new Label();
		header.setIcon(resource);
		titleLabel.setSizeUndefined();
		titleLabel.addStyleName(ValoTheme.LABEL_H4);
		titleLabel.addStyleName(ValoTheme.LABEL_COLORED);
//		header.addComponent(titleLabel);
		header.addComponent(gambar);
		header.addComponent(text());
		
		return header;
	}
	
	public VerticalLayout text(){
		VerticalLayout vl=new VerticalLayout();
		Label judul=new Label("Yayasan Pendidikan Hamzanwadi Pondok Pesantren Darun Nahdlatain Nahdatul Wathan\n");
		judul.addStyleName(ValoTheme.LABEL_H2);
		Label text=new Label(" Pesantren Darun Nahdlatain Nahdatul Wathan terletak di kelurahan Pancor "
				+ "kecamatan Selong kabupaten Lombok Timur Propinsi Nusa Tenggara Barat. "
				+ "Lokasi pondok pesantren dengan luas areal sekitar 17 hektar berada di 1 km dari kota Selong,"
				+ " ibu kota kabupaten Lombok Timur dan sekitar 60 km dari kota Mataram, ibukota provinsi NTB."
				+ " Lokasi dapat ditempuh melalui jalan darat dari Bandar Udara Internsaional Lombok (BIL) "
				+ "di kabupaten Lombok Tengah sekitar 90 menit dengan kendaraan bermotor dan sekitar 120 menit"
				+ " dari pelabuhan laut Lembar di kabupaten Lombok Barat."
				+ "YPH mengelola beberapa instansi pendidikan baik dari tingkat TK (taman kanak-kanak) hingga perguruan tinggi"
				+ "adapun instansi pendidikan yang dikelola YPh (yayasan pendidikan Hamzanwadi) antara lain 1 taman kanak-kanak (TK Hamzanwadi), "
				+ "1 Madrasah Ibtidaiyah Hamzanwadi, 4 MTs. diantaranya MTs. Mu'allimin NW Pancor, MTs. Mu'allimat NW Pancor,"
				+ "MTs. NW Pancor dan SMP Lab. Hamzanwadi, 6 tingkat SMA diantaranya MA, mu'allimin NW Pancor, MA. Mu'allimat NW pancor, MA. Hamzanwadi NW Pancor, "
				+ "MA. Keterampilan NW Pancor, SMA. NW Pancor dan SMK NW Pancor, sedangkan pada jenjang perguruan tinggi YPH mengelola 4 perguruan tinggi diantaranya"
				+ "MDQH (Ma'had Darul Qur'an Wal Hadits), STKIP (Sekolah Tinggi Keguruan dan Ilmu Pendidikan), IAIH (Institut Agama Islam  Hamzanwadi) dan STTH (Sekolah Tinggi Teknologi Hamzanwai)"
				+ "di samping mengelola instansi pendidikan, YPH juga mengelola beberapa instansi non pendidikan diantaranya POSKESTREN (Pos Kesehatan Pesantren), RHN (Radio Hamzanwadi),"
				+ " PADA (Pantai Asuhan Darul Aitam) dan KBIH (Kelompok Bimbingan Ibadah Hajji)");
		
		vl.addComponents(judul,text);
		return vl;
	}
	public VerticalLayout rightComponent(){
		VerticalLayout header = new VerticalLayout();
		header.addStyleName("viewheader");
		header.setSpacing(true);
		header.setSizeUndefined();
		
		String basepath = VaadinService.getCurrent()
				.getBaseDirectory().getAbsolutePath();
		FileResource resource = new FileResource(new File(basepath +"/WEB-INF/img/birul.jpeg"));
		titleLabel = new Label("YPH PPD NW PANCOR");
		Label gambar=new Label();
		gambar.setIcon(resource);
		titleLabel.setSizeUndefined(); 
		titleLabel.addStyleName(ValoTheme.LABEL_H3);
		header.addComponents(gambar);
		header.addComponent(titleLabel);
		header.setComponentAlignment(titleLabel, Alignment.MIDDLE_CENTER);
		return header;
	}
}
