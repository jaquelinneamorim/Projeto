package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.text.IconView;

import java.awt.Color;

import javax.swing.JButton;

import modelo.Efeitos;
import modelo.Imagem;
import modelo.Op_Logicas;
import modelo.Op_Matematicas;

import java.io.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.awt.image.RGBImageFilter;
import java.awt.Font;

public class Tela extends JFrame {

	private JPanel painelPrincipal;
	File imagem1 = null;
	File imagem2 = null;
	BufferedImage im1 = null;
	BufferedImage im2 = null;
	
	Efeitos efeitos = new Efeitos();
	Imagem imag = new Imagem();
	Op_Matematicas om = new Op_Matematicas();
	Op_Logicas ol = new Op_Logicas();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela frame = new Tela();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Tela() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 609);
		
		JLabel lbl_resultado = new JLabel("");
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnArquivo = new JMenu("Arquivo");
		menuBar.add(mnArquivo);
		
		JMenu mnEfeitos = new JMenu("Efeitos");
		menuBar.add(mnEfeitos);
		
		JMenuItem mntmNegativo = new JMenuItem("Negativo");
		mnEfeitos.add(mntmNegativo);
		mntmNegativo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
							
				BufferedImage imagem_negativa = efeitos.Negativo(imag.getIm1());
				lbl_resultado.setIcon(new ImageIcon(imagem_negativa));		
				lbl_resultado.setHorizontalAlignment(JLabel.CENTER);
			}
			
		});
		
		JMenuItem media = new JMenuItem("M\u00E9dia");
		mnEfeitos.add(media);
		media.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int mascara= 3;
				JOptionPane.showInputDialog("M�scara", mascara);
				BufferedImage media = efeitos.media(imag.getIm1(), mascara);
				lbl_resultado.setIcon(new ImageIcon(media));		
				lbl_resultado.setHorizontalAlignment(JLabel.CENTER);
							
			}
			
		});
		
		JMenuItem mediana = new JMenuItem("Mediana");
		mnEfeitos.add(mediana);
		mediana.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int mascara= 3;
				JOptionPane.showInputDialog("M�scara", mascara);
				BufferedImage mediana = efeitos.mediana(imag.getIm1(), mascara);
				lbl_resultado.setIcon(new ImageIcon(mediana));		
				lbl_resultado.setHorizontalAlignment(JLabel.CENTER);
							
			}
			
		});
		
		JMenuItem passa_alta = new JMenuItem("Passa alta");
		mnEfeitos.add(passa_alta);
		passa_alta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				BufferedImage passa_alta = efeitos.passa_alta(imag.getIm1());
				lbl_resultado.setIcon(new ImageIcon(passa_alta));		
				lbl_resultado.setHorizontalAlignment(JLabel.CENTER);
							
			}
			
		});
		
		JMenuItem passa_baixa = new JMenuItem("Passa baixa");
		passa_baixa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int a = 1;
				JOptionPane.showInputDialog("Valor para 'a', sendo a>=1: ", a);
				BufferedImage passa_baixo = efeitos.passa_baixo(imag.getIm1(),a);
				lbl_resultado.setIcon(new ImageIcon(passa_baixo));		
				lbl_resultado.setHorizontalAlignment(JLabel.CENTER);
							
			}
			
		});
		mnEfeitos.add(passa_baixa);
		
		JMenuItem prewitt = new JMenuItem("Prewitt");
		mnEfeitos.add(prewitt);
		prewitt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				BufferedImage prewitt = efeitos.prewitt(imag.getIm1());
				lbl_resultado.setIcon(new ImageIcon(prewitt));		
				lbl_resultado.setHorizontalAlignment(JLabel.CENTER);
							
			}
			
		});
		
		JMenuItem sobel = new JMenuItem("Sobel");
		mnEfeitos.add(sobel);
		sobel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				BufferedImage sobel = efeitos.prewitt(imag.getIm1());
				lbl_resultado.setIcon(new ImageIcon(sobel));		
				lbl_resultado.setHorizontalAlignment(JLabel.CENTER);
							
			}
			
		});
		
		JMenuItem gradiente = new JMenuItem("Gradiente");
		mnEfeitos.add(gradiente);
		
		JMenuItem mntmGradienteCruzado = new JMenuItem("Gradiente Cruzado");
		mnEfeitos.add(mntmGradienteCruzado);
		
		JMenu mnOperaesMatemticas = new JMenu("Opera\u00E7\u00F5es Matem\u00E1ticas");
		menuBar.add(mnOperaesMatemticas);
		
		JMenuItem soma = new JMenuItem("Soma");
		mnOperaesMatemticas.add(soma);
		soma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				BufferedImage soma = om.soma(imag.getIm1(), imag.getIm2());
				lbl_resultado.setIcon(new ImageIcon(soma));		
				lbl_resultado.setHorizontalAlignment(JLabel.CENTER);
			}
			
		});
		
		JMenuItem subtracao = new JMenuItem("Subtra\u00E7\u00E3o");
		mnOperaesMatemticas.add(subtracao);
		subtracao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				BufferedImage subtracao = om.subtracao(imag.getIm1(), imag.getIm2());
				lbl_resultado.setIcon(new ImageIcon(subtracao));		
				lbl_resultado.setHorizontalAlignment(JLabel.CENTER);
			}
			
		});
		
		JMenuItem multiplicacao = new JMenuItem("Multiplica\u00E7\u00E3o");
		mnOperaesMatemticas.add(multiplicacao);
		multiplicacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				BufferedImage multiplicacao = om.multiplicacao(imag.getIm1(), imag.getIm2());
				lbl_resultado.setIcon(new ImageIcon(multiplicacao));		
				lbl_resultado.setHorizontalAlignment(JLabel.CENTER);
			}
			
		});
		
		JMenuItem mntmDiviso = new JMenuItem("Divis\u00E3o");
		mnOperaesMatemticas.add(mntmDiviso);
		mntmDiviso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				BufferedImage divisao = om.divisao(imag.getIm1(), imag.getIm2());
				lbl_resultado.setIcon(new ImageIcon(divisao));		
				lbl_resultado.setHorizontalAlignment(JLabel.CENTER);
			}
			
		});
		
		JMenu mnOperaesLgicas = new JMenu("Opera\u00E7\u00F5es L\u00F3gicas");
		menuBar.add(mnOperaesLgicas);
		
		JMenuItem and = new JMenuItem("And");
		mnOperaesLgicas.add(and);
		
		JMenuItem or = new JMenuItem("Or");
		mnOperaesLgicas.add(or);
		or.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				BufferedImage or = ol.logica_or(imag.getIm1(), imag.getIm2());
				lbl_resultado.setIcon(new ImageIcon(or));		
				lbl_resultado.setHorizontalAlignment(JLabel.CENTER);
			}
			
		});
		
		JMenuItem xor = new JMenuItem("Xor");
		mnOperaesLgicas.add(xor);
		
		JMenu mnOperaesGeomtricas = new JMenu("Opera\u00E7\u00F5es Geom\u00E9tricas");
		menuBar.add(mnOperaesGeomtricas);
		
		JMenuItem escala_mais = new JMenuItem("Escala +");
		mnOperaesGeomtricas.add(escala_mais);
		
		JMenuItem escala_menos = new JMenuItem("Escala -");
		mnOperaesGeomtricas.add(escala_menos);
		
		JMenuItem rotacao_direita = new JMenuItem("Rota\u00E7\u00E3o \u00E0 direita");
		mnOperaesGeomtricas.add(rotacao_direita);
		
		JMenuItem rotacao_esquerda = new JMenuItem("Rota\u00E7\u00E3o \u00E0 Esquerda");
		mnOperaesGeomtricas.add(rotacao_esquerda);
		
		JMenuItem cisalhamento = new JMenuItem("Cisalhamento");
		mnOperaesGeomtricas.add(cisalhamento);
		
		JMenu mnAjuda = new JMenu("Ajuda");
		menuBar.add(mnAjuda);
		
		painelPrincipal = new JPanel();
		painelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(painelPrincipal);
		painelPrincipal.setLayout(null);
		
		JPanel painel1 = new JPanel();
		painel1.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		painel1.setBounds(42, 122, 303, 256);
		painelPrincipal.add(painel1);
		painel1.setLayout(null);
		
		JLabel lbl_imagem1 = new JLabel("");
		lbl_imagem1.setBackground(Color.WHITE);
		lbl_imagem1.setBounds(10, 11, 283, 234);
		painel1.add(lbl_imagem1);
		
		
		JButton btAbrirImagem1 = new JButton("Abrir Imagem");
		btAbrirImagem1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser img = new JFileChooser(); // Recebe imagem
				
				// if para verificar se o arquivo selecionado veio do bot�o  Abrir imagem 1
				if (img.showOpenDialog(btAbrirImagem1) == JFileChooser.APPROVE_OPTION){
					
					imagem1 = img.getSelectedFile(); // M�todo para passar imagem que foi selecionada
					im1 = new BufferedImage(256, 256, BufferedImage.TYPE_INT_RGB);
					
					try{
						im1 = ImageIO.read(imagem1);
						System.out.println("ok");
						
					}catch(Exception e){
						System.out.println("Erro");
					}
					imag.setIm1(im1); //Guarda imagem
													
					lbl_imagem1.setIcon(new ImageIcon(imagem1.toString()));
					lbl_imagem1.setHorizontalAlignment(JLabel.CENTER);
				}
			}
		});
		btAbrirImagem1.setBounds(117, 403, 131, 33);
		painelPrincipal.add(btAbrirImagem1);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel.setBounds(384, 122, 303, 256);
		painelPrincipal.add(panel);
		panel.setLayout(null);
		
		JLabel lbl_imagem2 = new JLabel("");
		lbl_imagem2.setBounds(10, 11, 271, 234);
		panel.add(lbl_imagem2);
		
		
		JButton btAbrirImagem2 = new JButton("Abrir Imagem");
		btAbrirImagem2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser img2 = new JFileChooser(); // Recebe imagem
				
				// if para verificar se o arquivo selecionado veio do bot�o  Abrir
				if (img2.showOpenDialog(btAbrirImagem2) == JFileChooser.APPROVE_OPTION){
					imagem2 = img2.getSelectedFile(); // M�todo para passar imagem que foi selecionada
					
					im2 = new BufferedImage(256, 256, BufferedImage.TYPE_INT_RGB);
					
					try{
						im2 = ImageIO.read(imagem2);
						System.out.println("ok");
						
					}catch(Exception c){
						System.out.println("Erro");
					}
					imag.setIm2(im2);
					lbl_imagem2.setIcon(new ImageIcon(imagem2.toString()));
					lbl_imagem2.setHorizontalAlignment(JLabel.CENTER);
				}
			}
		});
		btAbrirImagem2.setBounds(481, 403, 131, 33);
		painelPrincipal.add(btAbrirImagem2);
		
		JPanel painel_Resultado = new JPanel();
		painel_Resultado.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		painel_Resultado.setBounds(729, 122, 303, 256);
		painelPrincipal.add(painel_Resultado);
		painel_Resultado.setLayout(null);
		
		//lbl_resultado = new JLabel("");
		lbl_resultado.setBounds(10, 11, 283, 234);
		painel_Resultado.add(lbl_resultado);
		
		
				
		JLabel lblNewLabel = new JLabel("Imagem Resultado");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(820, 405, 163, 24);
		painelPrincipal.add(lblNewLabel);
		
		
		
		
		
		
	}
}
