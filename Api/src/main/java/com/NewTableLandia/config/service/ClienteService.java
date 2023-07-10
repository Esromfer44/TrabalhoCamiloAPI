package com.NewTableLandia.config.service;

import com.NewTableLandia.config.dto.ClienteDTO;
import com.NewTableLandia.config.mapper.DozerMapper;
import com.NewTableLandia.config.repository.ClienteRepository;
import com.NewTableLandia.config.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<ClienteDTO> findAll() {
        return DozerMapper.parseListObject(clienteRepository.findAll(), ClienteDTO.class);
    }

    public ClienteDTO findById(Long id) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(id);
        return clienteOptional.map(cliente -> DozerMapper.parseObject(cliente, ClienteDTO.class)).orElse(null);
    }

    public ClienteDTO save(ClienteDTO clienteDTO) {
        Cliente cliente = DozerMapper.parseObject(clienteDTO, Cliente.class);
        cliente = clienteRepository.save(cliente);
        return DozerMapper.parseObject(cliente, ClienteDTO.class);
    }

    public ClienteDTO update(ClienteDTO clienteDTO) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(clienteDTO.getId());
        if (clienteOptional.isPresent()) {
            Cliente cliente = clienteOptional.get();
            cliente.setNome(clienteDTO.getNome());
            cliente = clienteRepository.save(cliente);
            return DozerMapper.parseObject(cliente, ClienteDTO.class);
        }
        return null;
    }

    public String delete(Long id) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(id);
        if (clienteOptional.isPresent()) {
            clienteRepository.deleteById(id);
            return "Cliente with id " + id + " has been deleted!";
        }
        return "ID " + id + " not found!";
    }

    public Cliente criarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente atualizarCliente(Long id, Cliente cliente) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(id);
        if (clienteOptional.isPresent()) {
            cliente.setId(id);
            return clienteRepository.save(cliente);
        }
        return null;
    }

    public boolean excluirCliente(Long id) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(id);
        if (clienteOptional.isPresent()) {
            clienteRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

    public Cliente getClienteById(Long id) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(id);
        return clienteOptional.orElse(null);
    }
}
