package br.com.MBean;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import br.com.Entities.Usuario;

@ManagedBean
@SessionScoped
public class CadastroMB {

	Usuario u = new Usuario();

	List<Usuario> listU = new ArrayList<Usuario>();
	List<Usuario> listUs = new ArrayList<Usuario>();

	private static final String fileName = "Z:\\Teste\\CadastroAlunos.csv";

	public void Adicionar() {
		String a = u.getCpf().substring(0, 3);
		String b = u.getCpf().substring(4, 7);
		String c = u.getCpf().substring(8, 11);
		String d = u.getCpf().substring(12, 14);

		u.setCpf(a + b + c + d);
		Usuario usuario = new Usuario();

		usuario.setNome(u.getNome());
		usuario.setSobrenome(u.getSobrenome());
		usuario.setRa(u.getRa());
		usuario.setCpf(u.getCpf());

		listU.add(usuario);
		usuario = new Usuario();
		zerar();
	}

	public void script() {
		String[] cabecalho = { "Processar", "Usuario", "Nome", "Sobrenome", "Iniciais", "Descricao", "Escritorio",
				"Telefone", "Email", "Endereco", "Caixa Postal", "Cidade", "Estado", "CEP", "Pais", "Caminho do perfil",
				"Script de logon", "Caminho local", "Conectar", "A", "CPF", "Empresa", "Departamento", "Cargo",
				"Senha nunca expira", "Conta habilitada", "OU destino", "ProxyAddresses" };

		for (Usuario us : listU) {
			listUs.add(us);
		}

		try {
			Writer writer = Files.newBufferedWriter(Paths.get(CadastroMB.fileName));
			StatefulBeanToCsv<Usuario> beanToCsv = new StatefulBeanToCsvBuilder<Usuario>(writer).build();
			
			try {
				beanToCsv.write(listUs);
				
				writer.flush();
				writer.close();
			} catch (CsvDataTypeMismatchException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (CsvRequiredFieldEmptyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
