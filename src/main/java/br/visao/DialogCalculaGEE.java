package br.visao;

import br.CalculadoraGEE;
import br.CalculadoraGEEKm;
import br.CalculadoraGEELitro;
import br.LeArquivoJson;
import br.Carro;
import br.Combustivel;
import br.NotaPBE;
import br.Poluentes;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class DialogCalculaGEE extends JFrame{

    private List<Carro> carros;
    private CalculadoraGEE calculadoraGEE;
    private Map<NotaPBE, Color> corNotaPBE;

    //region Declaração componentes
    //region JPanel
    private JPanel pnlLegendaTransmVel;
    private JPanel pnlLegendaNotaPBE;
    private JPanel pnlPoluentes;
    private JPanel pnlCalcular;
    //endregion

    //region JLabel
    private JLabel labelTitulo;
    private JLabel labelCategoria;
    private JLabel labelMarca;
    private JLabel labelModelo;
    private JLabel labelVersao;
    private JLabel labelMotor;
    private JLabel labelTransmissao;
    private JLabel labelCombustivel;
    private JLabel labelNMHC;
    private JLabel labelCO;
    private JLabel labelNOx;
    private JLabel labelReducao;
    private JLabel labelResultado;
    //endregion

    //region JComboBox
    private JComboBox<String> cmbCategoria;
    private JComboBox<String> cmbMarca;
    private JComboBox<String> cmbModelo;
    private JComboBox<String> cmbVersao;
    private JComboBox<String> cmbMotor;
    private JComboBox<String> cmbTransmissao;
    private JComboBox<Combustivel> cmbCombustivel;
    //endregion

    //region JRadioButton
    private JRadioButton rbLitro;
    private JRadioButton rbKM;
    //endregion

    //region GroupButton
    private ButtonGroup bgTipoCalc;
    //endregion

    //region JTextField
    private JTextField txtValorCalc;
    //endregion

    //region JButton
    private JButton btnCalcular;
    private JButton btnLimpar;
    //endregion

    public DialogCalculaGEE(){
        Runnable buscaCarros = ()-> {
            Gson gson = new Gson();
            try {
                String json = new LeArquivoJson().readFile();
                java.lang.reflect.Type listType = new TypeToken<List<Carro>>(){}.getType();
                carros = gson.fromJson(json, listType);
            }catch (IOException e){
                System.out.println("Não foi possível ler o arquivo com os dados.");
            }
            init();
        };

        corNotaPBE = new HashMap<>();
        corNotaPBE.put(NotaPBE.A, new Color(34, 168, 66));
        corNotaPBE.put(NotaPBE.B, new Color(107, 168, 54));
        corNotaPBE.put(NotaPBE.C, new Color(131, 168, 35));
        corNotaPBE.put(NotaPBE.D, new Color(168, 118, 25));
        corNotaPBE.put(NotaPBE.E, new Color(168, 11, 9));

        new Thread(buscaCarros, "Buscadora de Carros").start();
    }

    public void createAndShowGUI(){
        setTitle("Calculadora GEE");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setPreferredSize(new Dimension(750, 550));

        JPanel pnlConteiner = new JPanel(null);

        getLabelTitulo().setBounds(0, 0, 750, 30);
        pnlConteiner.add(getLabelTitulo());

        //region Categoria
        getLabelCategoria().setBounds(10, 50, 80, 30);
        pnlConteiner.add(getLabelCategoria());

        getCmbCategoria().setBounds(130, 50, 160, 30);
        pnlConteiner.add(getCmbCategoria());
        //endregion

        //region Marca
        getLabelMarca().setBounds(10, 90, 80, 30);
        pnlConteiner.add(getLabelMarca());

        getCmbMarca().setBounds(130, 90, 160, 30);
        pnlConteiner.add(getCmbMarca());
        //endregion

        //region Modelo
        getLabelModelo().setBounds(10, 130, 80, 30);
        pnlConteiner.add(getLabelModelo());

        getCmbModelo().setBounds(130, 130, 160, 30);
        pnlConteiner.add(getCmbModelo());
        //endregion

        //region Versão
        getLabelVersao().setBounds(10, 170, 80, 30);
        pnlConteiner.add(getLabelVersao());

        getCmbVersao().setBounds(130, 170, 160, 30);
        pnlConteiner.add(getCmbVersao());
        //endregion

        //region Motor
        getLabelMotor().setBounds(10, 210, 80, 30);
        pnlConteiner.add(getLabelMotor());

        getCmbMotor().setBounds(130, 210, 160, 30);
        pnlConteiner.add(getCmbMotor());
        //endregion

        //region Transamissão
        getLabelTransmissao().setBounds(10, 250, 200, 30);
        pnlConteiner.add(getLabelTransmissao());

        getCmbTransmissao().setBounds(130, 250, 160, 30);
        pnlConteiner.add(getCmbTransmissao());
        //endregion

        //region Legenda Transmissao
        getPnlLegendaTransmVel().setBounds(300, 50, 280, 180);
        pnlConteiner.add(getPnlLegendaTransmVel());
        //endregion

        //region combustível
        getLabelCombustivel().setBounds(10, 290, 80, 30);
        pnlConteiner.add(getLabelCombustivel());

        getCmbCombustivel().setBounds(130, 290, 160, 30);
        pnlConteiner.add(getCmbCombustivel());
        //endregion

        //region legenda nota PBE
        getPnlLegendaNotaPBE().setBounds(300, 230, 280, 80);
        pnlConteiner.add(getPnlLegendaNotaPBE());
        //endregion

        //region Poluentes
        getPnlPoluentes().setBounds(10, 340, 290, 150);
        pnlConteiner.add(getPnlPoluentes());
        //endregion

        //region Calcular
        getPnlCalcular().setBounds(310, 340, 400, 150);

        //region TipoCalculo
        getRbLitro().setBounds(15, 15, 50, 30);
        getPnlCalcular().add(getRbLitro());

        getRbKM().setBounds(70, 15, 40, 30);
        getPnlCalcular().add(getRbKM());

        getBgTipoCalc().add(getRbKM());
        getBgTipoCalc().add(getRbLitro());
        //endregion

        //region Text Valor Calculo
        getTxtValorCalc().setBounds(15, 50, 180, 30);
        getPnlCalcular().add(getTxtValorCalc());
        //endregion

        //region Buttons
        getBtnCalcular().setBounds(15, 90, 80, 30);
        getPnlCalcular().add(getBtnCalcular());

        getBtnLimpar().setBounds(100, 90, 80, 30);
        getPnlCalcular().add(getBtnLimpar());
        //endregion

        //region Resultado
        getLabelResultado().setBounds(220, 15, 160, 100);
        getPnlCalcular().add(getLabelResultado());
        //endregion

        pnlConteiner.add(getPnlCalcular());
        //endregion


        setResizable(false);
        setContentPane(pnlConteiner);
        pack();
        setLocationRelativeTo(getParent());
        setVisible(true);
    }

    private void init(){
        List<String> categorias = new ArrayList<>();
        categorias.add("");
        categorias.addAll(carros.stream()
                .map(Carro::getCategoria)
                .distinct()
                .collect(Collectors.toList()));

        getTxtValorCalc().setText("");
        getLabelResultado().setText("0.00");
        atualizaCategoria(categorias);
    }

    private void calcular(){
        try{
            if(getCmbCategoria().getSelectedItem().equals("")){
                throw new IllegalArgumentException("Não é possível calcular sem informações do carro");
            }

            if(getRbKM().isSelected()){
                calculadoraGEE = new CalculadoraGEEKm();
            }else if(getRbLitro().isSelected()){
                calculadoraGEE = new CalculadoraGEELitro();
            }else{
                throw new IllegalArgumentException("Selecione uma modalidade de calculo");
            }

            Carro carro = carros.stream()
                    .filter(c ->
                            c.getCategoria().equals(getCmbCategoria().getSelectedItem()) &&
                            c.getMarca().equals(getCmbMarca().getSelectedItem()) &&
                            c.getModelo().equals(getCmbModelo().getSelectedItem()) &&
                            c.getVersao().equals(getCmbVersao().getSelectedItem()) &&
                            c.getMotor().equals(getCmbMotor().getSelectedItem()) &&
                            c.getTransmissao().equals(getCmbTransmissao().getSelectedItem())
                    ).findFirst().orElseThrow(() -> new IllegalArgumentException("Não foi possível encontra o carro com as informações escolhidas"));

            double valor = Double.parseDouble(getTxtValorCalc().getText());

            double co2 = calculadoraGEE.calcula(carro, (Combustivel) getCmbCombustivel().getSelectedItem(), valor);

            SwingUtilities.invokeLater(()->getLabelResultado().setText(String.format("%.2f", co2)));

        }catch (NumberFormatException e){
            JOptionPane.showMessageDialog(this, "O valor para calculo é inválido");

        }catch (IllegalArgumentException e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    //region Métodos de atualização de componentes
    private void atualizaCategoria(List<String> categoria){
        SwingUtilities.invokeLater(() -> {
            getCmbCategoria().removeAllItems();
            categoria.forEach(getCmbCategoria()::addItem);
        });
    }

    private void atualizaMarca(List<String> marca){
        SwingUtilities.invokeLater(()-> {
            getCmbMarca().removeAllItems();
            marca.forEach(getCmbMarca()::addItem);
        });
    }

    private void atualizaModelo(List<String> modelo){
        SwingUtilities.invokeLater(()->{
            getCmbModelo().removeAllItems();
            modelo.forEach(getCmbModelo()::addItem);
        });
    }

    private void atualizaVersao(List<String> versao){
        SwingUtilities.invokeLater(()->{
            getCmbVersao().removeAllItems();
            versao.forEach(getCmbVersao()::addItem);
        });
    }

    private void atualizaMotor(List<String> motor){
        SwingUtilities.invokeLater(()->{
            getCmbMotor().removeAllItems();
            motor.forEach(getCmbMotor()::addItem);
        });
    }

    private void atualizaTransmissao(List<String> transmissao){
        SwingUtilities.invokeLater(()->{
            getCmbTransmissao().removeAllItems();
            transmissao.forEach(getCmbTransmissao()::addItem);
        });
    }

    private void atualizaCombustivel(Set<Combustivel> combustivels){
        SwingUtilities.invokeLater(()->{
            getCmbCombustivel().removeAllItems();
            combustivels.forEach(getCmbCombustivel()::addItem);
        });
    }

    private void atualizaPoluentes(Poluentes poluentes){
        SwingUtilities.invokeLater(()->{

            String nmhc = String.valueOf(poluentes.getNmhc()).replace(".", ",");
            String co = String.valueOf(poluentes.getCo()).replace(".", ",");
            String nox = String.valueOf(poluentes.getNox()).replace(".", ",");

            getLabelNMHC().setText(nmhc);
            getLabelCO().setText(co);
            getLabelNOx().setText(nox);

            if(poluentes.getNotaReducaoPoluentes() != null){
                getLabelReducao().setForeground(corNotaPBE.get(poluentes.getNotaReducaoPoluentes()));
                getLabelReducao().setText(poluentes.getNotaReducaoPoluentes().name());
            }else{
                getLabelReducao().setForeground(Color.BLACK);
                getLabelReducao().setText("-");
            }

        });
    }
    //endregion

    //region Componentes
    //region JLabel
    private JLabel getLabelTitulo(){
        if(labelTitulo == null){
            labelTitulo = new JLabel("Calculadora de Emissões de Gás Efeito Estufa");
            labelTitulo.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
            labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        }
        return labelTitulo;
    }

    private JLabel getLabelCategoria(){
        if(labelCategoria == null){
            labelCategoria = new JLabel("Categoria");
        }
        return labelCategoria;
    }

    private JLabel getLabelMarca(){
        if(labelMarca == null){
            labelMarca = new JLabel("Marca");
        }
        return labelMarca;
    }

    private JLabel getLabelModelo(){
        if(labelModelo == null){
            labelModelo = new JLabel("Modelo");
        }
        return labelModelo;
    }

    private JLabel getLabelVersao(){
        if(labelVersao == null){
            labelVersao = new JLabel("Versão");
        }
        return labelVersao;
    }

    private JLabel getLabelMotor(){
        if(labelMotor == null){
            labelMotor = new JLabel("Motor");
        }
        return labelMotor;
    }

    private JLabel getLabelTransmissao(){
        if(labelTransmissao == null){
            labelTransmissao = new JLabel("Transm. Vel. (nº)");
        }
        return labelTransmissao;
    }

    private JLabel getLabelCombustivel(){
        if(labelCombustivel == null){
            labelCombustivel = new JLabel("Combustível");
        }
        return labelCombustivel;
    }

    private JLabel getLabelNMHC(){
        if(labelNMHC == null){
            labelNMHC = new JLabel();
        }
        return labelNMHC;
    }

    private JLabel getLabelCO(){
        if(labelCO == null){
            labelCO = new JLabel();
        }
        return labelCO;
    }

    private JLabel getLabelNOx(){
        if(labelNOx == null){
            labelNOx = new JLabel();
        }
        return labelNOx;
    }

    private JLabel getLabelReducao(){
        if(labelReducao == null){
            labelReducao = new JLabel();
            labelReducao.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
        }
        return labelReducao;
    }

    private JLabel getLabelResultado(){
        if(labelResultado == null) {
            labelResultado = new JLabel("0.00");
            labelResultado.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 24));
            labelResultado.setHorizontalAlignment(SwingConstants.CENTER);
        }
        return labelResultado;
    }
    //endregion

    //region JComboBox
    private JComboBox<String> getCmbCategoria(){
        if(cmbCategoria == null){
            cmbCategoria = new JComboBox<>();
            cmbCategoria.addActionListener(act->{
                List<String> carrosFiltrados = carros.stream()
                        .filter(carro -> carro.getCategoria().equals(getCmbCategoria().getSelectedItem()))
                        .map(Carro::getMarca)
                        .distinct()
                        .collect(Collectors.toList());

                atualizaMarca(carrosFiltrados);
            });
        }
        return cmbCategoria;
    }

    private JComboBox<String> getCmbMarca(){
        if(cmbMarca == null){
            cmbMarca = new JComboBox<>();
            cmbMarca.addActionListener(evt->{
                List<String> modelos = carros.stream()
                    .filter(carro ->
                        carro.getCategoria().equals(getCmbCategoria().getSelectedItem()) &&
                        carro.getMarca().equals(getCmbMarca().getSelectedItem())
                    ).map(Carro::getModelo)
                    .distinct()
                    .collect(Collectors.toList());

                atualizaModelo(modelos);
            });
        }
        return cmbMarca;
    }

    private JComboBox<String> getCmbModelo(){
        if(cmbModelo == null){
            cmbModelo = new JComboBox<>();
            cmbModelo.addActionListener(evt->{
                List<String> versoes = carros.stream()
                        .filter(carro ->
                                carro.getCategoria().equals(getCmbCategoria().getSelectedItem()) &&
                                        carro.getMarca().equals(getCmbMarca().getSelectedItem()) &&
                                        carro.getModelo().equals(getCmbModelo().getSelectedItem())
                        ).map(Carro::getVersao)
                        .distinct()
                        .collect(Collectors.toList());

                atualizaVersao(versoes);
            });
        }
        return cmbModelo;
    }

    private JComboBox<String> getCmbVersao(){
        if(cmbVersao == null){
            cmbVersao = new JComboBox<>();
            cmbVersao.addActionListener(evt->{
                List<String> motor = carros.stream()
                        .filter(carro ->
                                carro.getCategoria().equals(getCmbCategoria().getSelectedItem()) &&
                                        carro.getMarca().equals(getCmbMarca().getSelectedItem()) &&
                                        carro.getModelo().equals(getCmbModelo().getSelectedItem()) &&
                                        carro.getVersao().equals(getCmbVersao().getSelectedItem())
                        ).map(Carro::getMotor)
                        .distinct()
                        .collect(Collectors.toList());

                atualizaMotor(motor);
            });
        }
        return cmbVersao;
    }

    private JComboBox<String> getCmbMotor(){
        if(cmbMotor == null){
            cmbMotor = new JComboBox<>();
            cmbMotor.addActionListener(act->{
                List<String> transmissao = carros.stream()
                        .filter(carro ->
                                carro.getCategoria().equals(getCmbCategoria().getSelectedItem()) &&
                                        carro.getMarca().equals(getCmbMarca().getSelectedItem()) &&
                                        carro.getModelo().equals(getCmbModelo().getSelectedItem()) &&
                                        carro.getVersao().equals(getCmbVersao().getSelectedItem()) &&
                                        carro.getMotor().equals(getCmbMotor().getSelectedItem())
                        ).map(Carro::getTransmissao)
                        .distinct()
                        .collect(Collectors.toList());
                atualizaTransmissao(transmissao);
            });
        }
        return cmbMotor;
    }

    private JComboBox<String> getCmbTransmissao(){
        if(cmbTransmissao == null){
            cmbTransmissao = new JComboBox<>();
            cmbTransmissao.addActionListener(act->{
                Set<Combustivel> combustivel = carros.stream()
                        .filter(carro ->
                                carro.getCategoria().equals(getCmbCategoria().getSelectedItem()) &&
                                        carro.getMarca().equals(getCmbMarca().getSelectedItem()) &&
                                        carro.getModelo().equals(getCmbModelo().getSelectedItem()) &&
                                        carro.getVersao().equals(getCmbVersao().getSelectedItem()) &&
                                        carro.getMotor().equals(getCmbMotor().getSelectedItem()) &&
                                        carro.getTransmissao().equals(getCmbTransmissao().getSelectedItem())
                        ).map(Carro::getCombustivel).findFirst().orElse(new HashSet<>());

                atualizaCombustivel(combustivel);
            });
        }
        return cmbTransmissao;
    }

    private JComboBox<Combustivel> getCmbCombustivel(){
        if(cmbCombustivel == null){
            cmbCombustivel = new JComboBox<>();
            cmbCombustivel.addActionListener(act->{
                Poluentes poluentes = carros.stream()
                        .filter(carro ->
                                carro.getCategoria().equals(getCmbCategoria().getSelectedItem()) &&
                                        carro.getMarca().equals(getCmbMarca().getSelectedItem()) &&
                                        carro.getModelo().equals(getCmbModelo().getSelectedItem()) &&
                                        carro.getVersao().equals(getCmbVersao().getSelectedItem()) &&
                                        carro.getMotor().equals(getCmbMotor().getSelectedItem()) &&
                                        carro.getTransmissao().equals(getCmbTransmissao().getSelectedItem())
                        ).map(Carro::getPoluentes).findFirst().orElse(new Poluentes());
                        getBtnCalcular().setEnabled(true);
                atualizaPoluentes(poluentes);
            });
        }
        return cmbCombustivel;
    }
    //endregion

    //region JRadioButton
    private JRadioButton getRbLitro(){
        if(rbLitro == null){
            rbLitro = new JRadioButton("Litro");
        }
        return rbLitro;
    }

    private JRadioButton getRbKM(){
        if(rbKM == null){
            rbKM = new JRadioButton("KM");
        }
        return rbKM;
    }
    //endregion

    //region ButtonGroup
    private ButtonGroup getBgTipoCalc(){
        if(bgTipoCalc == null){
            bgTipoCalc = new ButtonGroup();
        }
        return bgTipoCalc;
    }
    //endregion

    //region JTextField
    private JTextField getTxtValorCalc(){
        if(txtValorCalc == null){
            txtValorCalc = new JTextField();
        }
        return txtValorCalc;
    }
    //endregion

    //region JButton
    private JButton getBtnCalcular(){
        if(btnCalcular == null){
            btnCalcular = new JButton("Calcular");
            btnCalcular.addActionListener(act->{
                calcular();
            });
        }
        return btnCalcular;
    }

    private JButton getBtnLimpar(){
        if(btnLimpar == null){
            btnLimpar = new JButton("Limpar");
            btnLimpar.addActionListener(act->{
                SwingUtilities.invokeLater(DialogCalculaGEE.this::init);
            });
        }
        return btnLimpar;
    }
    //endregion

    //region JPanel
    private JPanel getPnlLegendaTransmVel(){
        if(pnlLegendaTransmVel == null){
            pnlLegendaTransmVel = new JPanel();
            pnlLegendaTransmVel.setBorder(BorderFactory.createTitledBorder("Transm. Vel (nº)"));

            GridLayout gridLayout = new GridLayout(5,1);
            pnlLegendaTransmVel.setLayout(gridLayout);

            pnlLegendaTransmVel.add(new JLabel("Manual (M)"));
            pnlLegendaTransmVel.add(new JLabel("Automática (A)"));
            pnlLegendaTransmVel.add(new JLabel("Automática Dupla Embreagem (DCT)"));
            pnlLegendaTransmVel.add(new JLabel("Automatizada (MTA)"));
            pnlLegendaTransmVel.add(new JLabel("Contínua (CVT)"));

        }
        return pnlLegendaTransmVel;
    }

    private JPanel getPnlLegendaNotaPBE(){
        if(pnlLegendaNotaPBE == null){
            pnlLegendaNotaPBE = new JPanel();
            pnlLegendaNotaPBE.setBorder(BorderFactory.createTitledBorder("Nota PBE"));

            GridLayout gridLayout = new GridLayout(1,5);
            pnlLegendaNotaPBE.setLayout(gridLayout);

            JLabel a = new JLabel("A");
            a.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 25));
            a.setForeground(corNotaPBE.get(NotaPBE.A));
            pnlLegendaNotaPBE.add(a);

            JLabel b = new JLabel("B");
            b.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 25));
            b.setForeground(corNotaPBE.get(NotaPBE.B));
            pnlLegendaNotaPBE.add(b);

            JLabel c = new JLabel("C");
            c.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 25));
            c.setForeground(corNotaPBE.get(NotaPBE.C));
            pnlLegendaNotaPBE.add(c);

            JLabel d = new JLabel("D");
            d.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 25));
            d.setForeground(corNotaPBE.get(NotaPBE.D));
            pnlLegendaNotaPBE.add(d);

            JLabel e = new JLabel("E");
            e.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 25));
            e.setForeground(corNotaPBE.get(NotaPBE.E));
            pnlLegendaNotaPBE.add(e);
        }
        return pnlLegendaNotaPBE;
    }

    private JPanel getPnlPoluentes(){
        if(pnlPoluentes == null){
            pnlPoluentes = new JPanel();
            pnlPoluentes.setBorder(BorderFactory.createTitledBorder("Poluentes"));

            GridLayout gridLayout = new GridLayout(4, 2);
            gridLayout.setVgap(10);
            pnlPoluentes.setLayout(gridLayout);

            pnlPoluentes.add(new JLabel("NMHC (g/km)"));
            pnlPoluentes.add(getLabelNMHC());
            pnlPoluentes.add(new JLabel("CO (g/km)"));
            pnlPoluentes.add(getLabelCO());
            pnlPoluentes.add(new JLabel("NOx (g/km)"));
            pnlPoluentes.add(getLabelNOx());
            pnlPoluentes.add(new JLabel("Redução"));
            pnlPoluentes.add(getLabelReducao());

        }
        return pnlPoluentes;
    }

    private JPanel getPnlCalcular(){
        if(pnlCalcular == null){
            pnlCalcular = new JPanel(null);
            pnlCalcular.setBorder(BorderFactory.createTitledBorder("Calcular emissão CO²"));
        }
        return pnlCalcular;
    }
    //endregion
    //endregion
}
