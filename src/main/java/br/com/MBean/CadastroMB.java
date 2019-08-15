package br.com.MBean;

import java.io.File;

import java.io.FileOutputStream;

import java.util.ArrayList;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.FileInputStream;
import java.io.*;
import org.apache.poi.ss.usermodel.*;
import java.util.Iterator;
import java.io.FileWriter;
import au.com.bytecode.opencsv.CSVWriter;

import br.com.Entities.Usuario;

@ManagedBean
@SessionScoped
public class CadastroMB {

	Usuario u = new Usuario();

	List<Usuario> listU = new ArrayList<Usuario>();

	HSSFWorkbook workbook = new HSSFWorkbook();

	HSSFSheet fistSheet;

	private static final String fileName = "Z:\\Teste\\CadastroAlunos.xls";
	private static final String filename2 = "CadastroAlunos.xls";

	public void Adicionar() {
		String a = u.getCpf().substring(0, 3);
		String b = u.getCpf().substring(4, 7);
		String c = u.getCpf().substring(8, 11);
		String d = u.getCpf().substring(12, 14);

		u.setCpf(a + b + c + d);
		Usuario usuario = new Usuario();

		usuario.setNome(u.getNome());
		usuario.setSobrenome(u.getSobrenome());
		usuario.setUsuario(u.getUsuario());
		usuario.setCpf(u.getCpf());

		listU.add(usuario);
		usuario = new Usuario();
		zerar();
	}

	public void script() {
		fistSheet = workbook.createSheet("Cadastro");

		int i = 1;

		HSSFRow row0 = fistSheet.createRow(0);

		row0.createCell(0).setCellValue("Processar");
		row0.createCell(1).setCellValue("Usuario");
		row0.createCell(2).setCellValue("Nome");
		row0.createCell(3).setCellValue("Sobrenome");
		row0.createCell(4).setCellValue("Iniciais");
		row0.createCell(5).setCellValue("Descricao");
		row0.createCell(6).setCellValue("Escritorio");
		row0.createCell(7).setCellValue("Telefone");
		row0.createCell(8).setCellValue("Email");
		row0.createCell(9).setCellValue("Endereco");
		row0.createCell(10).setCellValue("Caixa Postal");
		row0.createCell(11).setCellValue("Cidade");
		row0.createCell(12).setCellValue("Estado");
		row0.createCell(13).setCellValue("CEP");
		row0.createCell(14).setCellValue("Pais");
		row0.createCell(15).setCellValue("Caminho do perfil");
		row0.createCell(16).setCellValue("Script de logon");
		row0.createCell(17).setCellValue("Caminho local");
		row0.createCell(18).setCellValue("Conectar");
		row0.createCell(19).setCellValue("A");
		row0.createCell(20).setCellValue("CPF");
		row0.createCell(21).setCellValue("Empresa");
		row0.createCell(22).setCellValue("Departamento");
		row0.createCell(23).setCellValue("Cargo");
		row0.createCell(24).setCellValue("Senha nunca expira");
		row0.createCell(25).setCellValue("Conta habilitada");
		row0.createCell(26).setCellValue("OU destino");
		row0.createCell(27).setCellValue("ProxyAddresses");

		for (Usuario u : listU) {
			HSSFRow row = fistSheet.createRow(i);

			row.createCell(0).setCellValue(u.getProcessar());
			row.createCell(1).setCellValue(u.getUsuario());
			row.createCell(2).setCellValue(u.getNome());
			row.createCell(3).setCellValue(u.getSobrenome());
			row.createCell(4).setCellValue(u.getIniciais());
			row.createCell(5).setCellValue(u.getDescricao());
			row.createCell(6).setCellValue(u.getEscritorio());
			row.createCell(7).setCellValue(u.getTelefone());
			row.createCell(8).setCellValue(u.getEmail());
			row.createCell(9).setCellValue(u.getEndereco());
			row.createCell(10).setCellValue(u.getCaixaPostal());
			row.createCell(11).setCellValue(u.getCidade());
			row.createCell(12).setCellValue(u.getEstado());
			row.createCell(13).setCellValue(u.getCep());
			row.createCell(14).setCellValue(u.getPais());
			row.createCell(15).setCellValue(u.getCaminhoDoPerfil());
			row.createCell(16).setCellValue(u.getScriptDeLogon());
			row.createCell(17).setCellValue(u.getCaminhoLocal());
			row.createCell(18).setCellValue(u.getConectar());
			row.createCell(19).setCellValue(u.getA());
			row.createCell(20).setCellValue(u.getCpf());
			row.createCell(21).setCellValue(u.getEmpresa());
			row.createCell(22).setCellValue(u.getDepartamento());
			row.createCell(23).setCellValue(u.getCargo());
			row.createCell(24).setCellValue(u.getSenhaNuncaExpira());
			row.createCell(25).setCellValue(u.getContaHabilitada());
			row.createCell(26).setCellValue(u.getOuDestino());
			row.createCell(27).setCellValue(u.getProxyAddresses());

			i++;

		}
		try {
			FileOutputStream fos = new FileOutputStream(new File(CadastroMB.fileName));
			workbook.write(fos);
			fos.close();
			converter();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void converter() {
		// First we read the Excel file in binary format into FileInputStream
		FileInputStream input_document = new FileInputStream(new File(CadastroMB.fileName));
		// Read workbook into HSSFWorkbook
		HSSFWorkbook my_xls_workbook = new HSSFWorkbook(input_document);
		// Read worksheet into HSSFSheet
		HSSFSheet my_worksheet = my_xls_workbook.getSheetAt(0);
		// To iterate over the rows
		Iterator<Row> rowIterator = my_worksheet.iterator();
		// OpenCSV writer object to create CSV file
		FileWriter my_csv = new FileWriter(CadastroMB.filename2);
		CSVWriter my_csv_output = new CSVWriter(my_csv);
		// Loop through rows.
		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();
			int i = 0;// String array
			// change this depending on the length of your sheet
			String[] csvdata = new String[2];
			Iterator<Cell> cellIterator = row.cellIterator();
			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next(); // Fetch CELL
				switch (cell.getCellType()) { // Identify CELL type
				// you need to add more code here based on
				// your requirement / transformations
				case Cell.CELL_TYPE_STRING:
					csvdata[i] = cell.getStringCellValue();
					break;
				}
				i = i + 1;
			}
			my_csv_output.writeNext(csvdata);
		}
		my_csv_output.close(); // close the CSV file
		// we created our file..!!
		input_document.close(); // close xls
	}

	private void zerar() {
		u = new Usuario();
	}

	public Usuario getU() {
		return u;
	}

	public void setU(Usuario u) {
		this.u = u;
	}

	public List<Usuario> getListU() {
		return listU;
	}

	public void setListU(List<Usuario> listU) {
		this.listU = listU;
	}

}
