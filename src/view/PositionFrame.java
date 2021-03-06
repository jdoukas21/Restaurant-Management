package view;

/*
 * @author Tu Thi Xuan Hien
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import model.PositionTitle;

public class PositionFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JComboBox cboTitle;
	private JButton btnUpdate, btnSave, btnExit;

	private JTextField txtSalary, txtOtherSalary;
	private JTable tblDetail;
	private DefaultTableModel tblModel;

	public PositionFrame(String strTitle) {
		super(strTitle);
		createUI();
		setDefaultCloseOperation(HIDE_ON_CLOSE);
	}

	private void createUI() {
		JPanel pnGeneral = new JPanel();
		JPanel pnGeneralBorder = new JPanel();
		Container con = getContentPane();
		con.add(pnGeneralBorder);
		pnGeneralBorder.add(pnGeneral);
		pnGeneral.setLayout(new BorderLayout());

		JPanel pnTitle = new JPanel();
		JLabel lblTitle = new JLabel("Position Information");
		lblTitle.setForeground(Color.BLUE);
		Font font = new Font("Arial", Font.BOLD, 25);
		lblTitle.setFont(font);
		pnTitle.add(lblTitle);
		pnGeneral.add(pnTitle, BorderLayout.NORTH);

		JPanel pnInformation = new JPanel();
		JPanel pnInputInformation = new JPanel();

		pnInformation.setLayout(new BoxLayout(pnInformation, BoxLayout.Y_AXIS));
		pnInputInformation.setLayout(new BoxLayout(pnInputInformation,
				BoxLayout.Y_AXIS));
		pnInformation.add(pnInputInformation);

		JPanel pnPositionTitle = new JPanel();
		JLabel lblPositionTitle = new JLabel("Position Title");
		cboTitle = new JComboBox();
		addPositionTitleForCombobox();
		pnPositionTitle.add(lblPositionTitle);
		pnPositionTitle.add(cboTitle);
		pnGeneral.add(pnInformation, BorderLayout.CENTER);
		pnInputInformation.add(pnPositionTitle);

		JPanel pnSalary = new JPanel();
		JLabel lblSalary = new JLabel("Salary");
		txtSalary = new JTextField(15);
		pnSalary.add(lblSalary);
		pnSalary.add(txtSalary);
		pnInputInformation.add(pnSalary);

		JPanel pnOtherSalary = new JPanel();
		JLabel lblOtherSalary = new JLabel("Other Salary");
		txtOtherSalary = new JTextField(15);
		pnOtherSalary.add(lblOtherSalary);
		pnOtherSalary.add(txtOtherSalary);
		pnInputInformation.add(pnOtherSalary);

		// set JLabels are same size
		lblSalary.setPreferredSize(lblPositionTitle.getPreferredSize());
		lblOtherSalary.setPreferredSize(lblPositionTitle.getPreferredSize());

		// create Border for each JPanel
		TitledBorder border = new TitledBorder(
				BorderFactory.createLineBorder(Color.RED), "Detail Information");

		pnInputInformation.setBorder(border);

		JPanel pnButton = new JPanel();

		btnSave = new JButton("Save");
		ImageIcon iconSave = new ImageIcon("images/Save.png");
		btnSave.setIcon(iconSave);

		btnUpdate = new JButton("Update");
		ImageIcon iconEdit = new ImageIcon("images/modify.png");
		btnUpdate.setIcon(iconEdit);

		pnButton.add(btnSave);
		pnButton.add(btnUpdate);
		TitledBorder borderButtons = new TitledBorder(
				BorderFactory.createLineBorder(Color.RED), "Choose Action:");

		pnButton.setBorder(borderButtons);

		pnInformation.add(pnButton);

		// create Table
		JPanel pnTable = new JPanel();
		pnTable.setLayout(new BorderLayout());
		pnInformation.add(pnTable);
		tblModel = new DefaultTableModel();
		// Add Column for TableModel
		tblModel.addColumn("Position Title");
		tblModel.addColumn("Salary (USD)");
		tblModel.addColumn("Other Salary (USD)");
		
		tblDetail = new JTable(tblModel);
		JScrollPane sc = new JScrollPane(tblDetail);
		sc.setPreferredSize(new Dimension(500, 200));
		pnTable.add(sc, BorderLayout.CENTER);
		TitledBorder borderTable = new TitledBorder(
				BorderFactory.createLineBorder(Color.RED), "Position List:");
		pnTable.setBorder(borderTable);
		btnExit = new JButton("Close");
		JPanel pnSouth = new JPanel();
		pnSouth.setLayout(new FlowLayout(FlowLayout.RIGHT));
		ImageIcon iconExit = new ImageIcon("images/close.png");
		btnExit.setIcon(iconExit);
		pnSouth.add(btnExit);
		pnGeneral.add(pnSouth, BorderLayout.SOUTH);

		btnUpdate.setMnemonic('E');
		btnSave.setMnemonic('S');
	}

	private void addPositionTitleForCombobox() {
		for (PositionTitle title : PositionTitle.values()) {
			cboTitle.addItem(PositionTitle.getTitleString(title));
		}
	}

	public JButton getButtonUpdate() {
		return btnUpdate;
	}

	public JButton getButtonSave() {
		return btnSave;
	}

	public JButton getButtonExit() {
		return btnExit;
	}

	public JComboBox getComboBoxTitle() {
		return cboTitle;
	}

	public JTable getDetailTable() {
		return tblDetail;
	}

	public DefaultTableModel getTableModel() {
		return tblModel;
	}

	public JTextField getTextFieldSalary() {
		return txtSalary;
	}

	public JTextField getTextFieldOtherSalary() {
		return txtOtherSalary;
	}
}
