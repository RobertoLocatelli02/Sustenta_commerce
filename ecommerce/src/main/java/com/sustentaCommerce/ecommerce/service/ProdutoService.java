package com.sustentaCommerce.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sustentaCommerce.ecommerce.model.Produtos;
import com.sustentaCommerce.ecommerce.repository.CategoriaRepository;
import com.sustentaCommerce.ecommerce.repository.ProdutosRepository;
import com.sustentaCommerce.ecommerce.repository.UsuarioRepository;

@Service
public class ProdutoService {
    
    @Autowired
    private ProdutosRepository repositoryP;
    @Autowired
    private UsuarioRepository repositoryU;
    @Autowired
    private CategoriaRepository repositoryC;

    public Produtos postProduto(Produtos novoProduto, Long idCategoria, Long idUsuario) {
        novoProduto.setCategoria_produtos_criados(repositoryC.findById(idCategoria).get());
        novoProduto.setUsuario_produtos_criados(repositoryU.findById(idUsuario).get());
        return repositoryP.save(novoProduto);
}

    public Produtos putProduto(Produtos produtoAtualizado, Long idCategoria, Long idUsuario) {
        produtoAtualizado.setCategoria_produtos_criados(repositoryC.findById(idCategoria).get());
        produtoAtualizado.setUsuario_produtos_criados(repositoryU.findById(idUsuario).get());
        return repositoryP.save(produtoAtualizado);
    }
}