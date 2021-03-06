package org.pdtyph.jee.ui.opryayasan;


import com.vaadin.navigator.View;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.Resource;

public enum OprYayasanMenuItems {
	DASHBOARD("Dashboard ", Dashboard.class, FontAwesome.DASHBOARD, true),
		
	KELOLAINSTANSI("Profil Instansi", DaftarInstansi.class, FontAwesome.HOME, false),
	KELOLAUSER("Data User Instansi", DaftarUser.class, FontAwesome.USER, false),
	KELOLAUSERYAYASAN("Data User Yayasan", DaftarUserYayasan.class, FontAwesome.USER, false),
	
	
	CARIDATA("Pencarian", DaftarPencarian.class, FontAwesome.SEARCH, true),
	PENDIDIKANDOSEN("Jumlah Pegawai (Pendidikan)", GrafikJumlahDosenPendidikan.class, FontAwesome.TH, false),
	JUMLAHDOSEN("Jumlah Pegawai (Jenis Kelamin)", GrafikJumlahDosenKelamin.class, FontAwesome.TH_LIST, false),
	IKATANKERJADOSEN("Jumlah Pegawai (Ikatan Kerja)", GrafikJumlahDosenKerja.class, FontAwesome.TH_LARGE, false);
	
	private final String viewName;
	private final Class<? extends View> viewClass;
	private final Resource icon;
	private final boolean stateful;

	private OprYayasanMenuItems(String viewName, Class<? extends View> viewClass,
			Resource icon, boolean stateful) {
		this.viewName = viewName;
		this.viewClass = viewClass;
		this.icon = icon;
		this.stateful = stateful;
	}

	public String getViewName() {
		return viewName;
	}

	public Class<? extends View> getViewClass() {
		return viewClass;
	}

	public Resource getIcon() {
		return icon;
	}

	public boolean isStateful() {
		return stateful;
	}





}
