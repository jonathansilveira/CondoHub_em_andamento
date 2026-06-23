package _01_Classes;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableModel;

public class ControlProp {

    ConectaBanco conecta = new ConectaBanco();  // Instancia a classe para conexão com o banco de dados

    // Método para inserir dados na tabela 'propriedades'
    public void insert(ModelProp mod) {
        try {
            conecta.conexao();  // Estabelece a conexão com o banco de dados
            // Prepara a instrução SQL para inserir os dados da propriedade na tabela
            PreparedStatement pst = conecta.conn.prepareStatement(
                "INSERT INTO propriedades (id, nome, endereco, cep, cpf, tipo, tamanho, vila_cidade, agrotoxico) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)"
            );
            // Preenche os parâmetros da consulta com os dados fornecidos
            pst.setInt(1, mod.getId());
            pst.setString(2, mod.getNome());
            pst.setString(3, mod.getEndereco());
            pst.setString(4, mod.getCep());
            pst.setString(5, mod.getCpf());
            pst.setString(6, mod.getTipo());
            pst.setString(7, mod.getTamanho());
            pst.setString(8, mod.getVila_Cidade());
            pst.setString(9, mod.getAgrotoxico());
            pst.executeUpdate();  // Executa a instrução SQL
            // Exibe uma mensagem de sucesso
            JOptionPane.showMessageDialog(null, "Dados da propriedade: " + mod.getNome() + " cadastrados", "Confirmação", JOptionPane.INFORMATION_MESSAGE);
            conecta.desconecta();  // Desconecta do banco de dados
        } catch (SQLException ex) {
            System.out.println("Error: " + ex);  // Exibe qualquer erro no console
        }
    }

    // Método para atualizar dados de uma propriedade com o id fornecido
    public void update(ModelProp mod, int id) {
        conecta.conexao();  // Estabelece a conexão com o banco de dados
        try {
            // Prepara a instrução SQL para atualizar os dados da propriedade
            PreparedStatement pst = conecta.conn.prepareStatement(
                "UPDATE propriedades SET nome= ?, endereco= ?, cep= ?, cpf= ?, tipo= ?, tamanho= ?, vila_cidade= ?, agrotoxico= ? WHERE id=?"
            );
            // Preenche os parâmetros da consulta com os novos dados fornecidos
            pst.setString(1, mod.getNome());
            pst.setString(2, mod.getEndereco());
            pst.setString(3, mod.getCep());
            pst.setString(4, mod.getCpf());
            pst.setString(5, mod.getTipo());
            pst.setString(6, mod.getTamanho());
            pst.setString(7, mod.getVila_Cidade());
            pst.setString(8, mod.getAgrotoxico());
            pst.setInt(9, id);  // Define o id da propriedade a ser atualizada
            pst.execute();  // Executa a instrução SQL
            // Exibe uma mensagem de confirmação
            JOptionPane.showMessageDialog(null, "Dados da propriedade: " + mod.getNome() + " atualizados", "Confirmação", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar dados\n ERRO: " + ex);  // Exibe uma mensagem de erro
        }
        conecta.desconecta();  // Desconecta do banco de dados
    }

    // Método para excluir uma propriedade com o id fornecido
    public void delete(int id) {
        // Pergunta ao usuário se ele tem certeza que deseja excluir o dado
        int resposta = JOptionPane.showConfirmDialog(
            null, 
            "Deseja excluir esta propriedade?", 
            "Confirmar Exclusão", 
            JOptionPane.YES_NO_OPTION, 
            JOptionPane.WARNING_MESSAGE
        );

        // Se o usuário clicar em "Sim", a exclusão será realizada
        if (resposta == JOptionPane.YES_OPTION) {
            conecta.conexao();  // Conecta ao banco de dados
            try {
                // Comando SQL para excluir o dado com o id informado
                PreparedStatement pst = conecta.conn.prepareStatement("DELETE FROM propriedades WHERE id = ?");
                pst.setInt(1, id);  // Passa o id de forma segura
                pst.executeUpdate();  // Executa a exclusão
                // Exibe uma mensagem de sucesso após a exclusão
                JOptionPane.showMessageDialog(null, "Excluído com sucesso", "Confirmação", JOptionPane.INFORMATION_MESSAGE);
            } catch (SQLException e) {
                // Em caso de erro ao excluir, exibe uma mensagem de erro
                JOptionPane.showMessageDialog(null, "Erro ao excluir. Tente novamente!", "Erro", JOptionPane.ERROR_MESSAGE);
            } finally {
                conecta.desconecta();  // Desconecta do banco de dados
            }
        } else {
            // Se o usuário clicar em "Não", a operação é cancelada
            JOptionPane.showMessageDialog(null, "Exclusão cancelada.", "Cancelado", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    // Método para preencher a tabela com os dados da consulta SQL fornecida
    public void preencherTabela(String SQL, JTable tabela2) {
        conecta.conexao();  // Estabelece a conexão com o banco de dados
        ArrayList dados = new ArrayList();  // Lista para armazenar os dados da consulta
        String[] Colunas = new String[]{"","ID","Nome", "Endereço", "CEP", "CPF", "Tipo", "Tamanho", "Vila/Cidade", "Agrotóxico"};  // Cabeçalhos das colunas
        conecta.executaSQL(SQL);  // Executa a consulta SQL
        try {
            conecta.rs.first();  // Move para o primeiro registro do ResultSet
            do {
                // Adiciona os dados da propriedade na lista 'dados'
                dados.add(new Object[]{
                    "",  // Coluna vazia para controle visual
                    conecta.rs.getInt("id"),  
                    conecta.rs.getString("nome"),
                    conecta.rs.getString("endereco"),
                    conecta.rs.getString("cep"),
                    conecta.rs.getString("cpf"),
                    conecta.rs.getString("tipo"),
                    conecta.rs.getString("tamanho"),
                    conecta.rs.getString("vila_cidade"),
                    conecta.rs.getString("agrotoxico")
                });
            } while (conecta.rs.next());  // Continua iterando enquanto houver registros

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lista de Cadastro Vazia!");  // Exibe uma mensagem se a consulta retornar vazia
        } finally {
            conecta.desconecta();  // Desconecta do banco de dados
        }

        // Cria um modelo de tabela com os dados e colunas fornecidas
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        tabela2.setModel((TableModel) modelo);  // Define o modelo de dados para a tabela
        // Configura as colunas para não serem redimensionadas
        tabela2.getColumnModel().getColumn(1).setMaxWidth(0);
        tabela2.getColumnModel().getColumn(1).setMinWidth(0);
        tabela2.getTableHeader().getColumnModel().getColumn(1).setMaxWidth(0);
        tabela2.getTableHeader().getColumnModel().getColumn(1).setMinWidth(0);
        tabela2.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);  // Desabilita o redimensionamento automático das colunas
        tabela2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);  // Define que apenas uma linha pode ser selecionada por vez
    }
}
