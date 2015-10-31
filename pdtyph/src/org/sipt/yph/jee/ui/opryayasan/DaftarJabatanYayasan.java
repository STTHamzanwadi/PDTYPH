package org.sipt.yph.jee.ui.opryayasan;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Date;
import java.util.List;

import org.pdtyph.entity.JabatanYayasan;
import org.pdtyph.entity.UserOprInstansi;
import org.pdtyph.entity.UserOprYayasan;
import org.yph.jee.persistence.GenericPersistence;
import org.yph.jee.util.PasswordEncryptionService;

import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanContainer;
import com.vaadin.data.util.BeanItem;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.Responsive;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Table;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Table.ColumnGenerator;
import com.vaadin.ui.themes.ValoTheme;

public class DaftarJabatanYayasan extends Panel implements View{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8265667895917038873L;
	private Table tabel = new Table("DAFTAR JABATAN LEMBAGA YPHPPD NW PANCOR");
	private VerticalLayout dashboardPanels;
	private VerticalLayout root;
	private FieldGroup binder;
	private BeanContainer<Integer, JabatanYayasan> beans = new BeanContainer<Integer, JabatanYayasan>(JabatanYayasan.class);

	@SuppressWarnings("serial")
	public DaftarJabatanYayasan() {
		addStyleName(ValoTheme.PANEL_BORDERLESS);
		root = new VerticalLayout();
		root.setSizeFull();
		root.setSpacing(true);
		root.setMargin(true);
		root.addStyleName("dashboard-view");
		setContent(root);
		Responsive.makeResponsive(root);
		root.addComponent(getTable());
		Button tambah=new Button("Tambah",FontAwesome.PLUS_SQUARE_O);
		root.addComponent(tambah);
		tambah.addClickListener(new ClickListener() {
			@Override public void buttonClick(ClickEvent event) {
				tambahJabatanbaru(new JabatanYayasan());
				try {
					dor();
				} catch (NoSuchAlgorithmException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvalidKeySpecException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			}

		});
		tambah.addStyleName(ValoTheme.BUTTON_FRIENDLY);
		

	}
	
	protected void dor() throws NoSuchAlgorithmException, InvalidKeySpecException {
		UserOprYayasan  u = new UserOprYayasan();
		u.setEmail("operator@hamzanwadi.org");
		u.setNama("harianto");
		u.setUserName("admin");
		u.setRealName("Operator 1");
		u.setRegisterDate(new Date());
		byte[] salt = PasswordEncryptionService.generateSalt();
		byte[] pass = PasswordEncryptionService.getEncryptedPassword("admin", salt);		
		u.setSalt(salt);
		u.setPassword(pass);
		u.setLastSuccessfulLogin(new Date());
		GenericPersistence.merge(u);
		
	}
	@SuppressWarnings("serial")
	private Component getTable(){
		List<JabatanYayasan> pr =GenericPersistence.findList(JabatanYayasan.class);

		dashboardPanels = new VerticalLayout();
		dashboardPanels.addStyleName("dashboard-panels");
		Responsive.makeResponsive(dashboardPanels);
		beans.setBeanIdProperty("id");
		beans.removeAllItems();
		if (pr!=null){
			beans.addAll(pr);
		} else {
			beans.addBean(new JabatanYayasan());
		}

		tabel.addGeneratedColumn("aksi", new ColumnGenerator() {
			@Override
			public Object generateCell(Table source, Object itemId, Object columnId) {
				HorizontalLayout hl = new HorizontalLayout();
				Button edit = new Button(FontAwesome.EDIT);
				Button hapus = new Button(FontAwesome.TRASH_O);
				edit.addStyleName(ValoTheme.BUTTON_FRIENDLY);
				edit.addStyleName(ValoTheme.BUTTON_SMALL);
				hapus.addStyleName(ValoTheme.BUTTON_FRIENDLY);
				hapus.addStyleName(ValoTheme.BUTTON_SMALL);
				BeanItem<?> p = (BeanItem<?>) source.getContainerDataSource().getItem(itemId);
				final JabatanYayasan o = (JabatanYayasan) p.getBean();
				edit.addClickListener(new ClickListener() {
					@Override public void buttonClick(ClickEvent event) {
						tambahJabatanbaru(o);
					}

				});
				hapus.addClickListener(new ClickListener() {
					@Override public void buttonClick(ClickEvent event) {
						try {
							binder.commit();
							BeanItem<?> bi = (BeanItem<?>) binder.getItemDataSource();
							GenericPersistence.delete(bi.getBean());
						} catch (Exception e) {
							// TODO: handle exception
						}
						
					}

				});

				hl.addComponent(edit);
				hl.addComponent(hapus);
				return hl;
			}
		});
		tabel.setSizeFull();
		tabel.setImmediate(true);
		tabel.setSelectable(true);
		tabel.setContainerDataSource(beans);
		tabel.setRowHeaderMode(Table.RowHeaderMode.INDEX);
		tabel.setColumnHeader("namaJabatan", "NAMA JABATAN");
		
		tabel.setColumnHeader("jnsJabatan", "JENIS JABATAN");
		tabel.setColumnHeader("urut", "URUT JABATAN");
		tabel.setColumnHeader("aksi", "AKSI");
		tabel.setVisibleColumns("aksi","namaJabatan","jnsJabatan","urut");
		dashboardPanels.addComponent(tabel);
		return dashboardPanels;
	}

	private void tambahJabatanbaru(JabatanYayasan j) {
		final Window win = new Window("Tambah Jabatan Baru");
		Component c = new TambahJabatan(j,win);
		VerticalLayout vl = new VerticalLayout();
		vl.setMargin(true);
		vl.addComponent(c);
		win.setContent(vl);
		win.setModal(true);
		win.setWidth("600px");
		win.center();
		UI.getCurrent().addWindow(win);

	}

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub

	}


}
