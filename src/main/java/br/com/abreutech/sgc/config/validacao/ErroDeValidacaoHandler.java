package br.com.abreutech.sgc.config.validacao;

import br.com.abreutech.sgc.exception.RegistroDuplicadoException;
import br.com.abreutech.sgc.exception.RegistroNaoExisteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestControllerAdvice
public class ErroDeValidacaoHandler extends ResponseEntityExceptionHandler {
	
	@Autowired
	private MessageSource messageSource;

	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(
			HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

		String statusError = HttpStatus.BAD_REQUEST.toString();
		String message = messageSource.getMessage("MSG-R001", null, LocaleContextHolder.getLocale());
		String trace = ex.toString();
		List<Erro> erros = Arrays.asList(new Erro(statusError, message, trace));

		return handleExceptionInternal(ex, erros, headers, HttpStatus.BAD_REQUEST, request);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<ErroDeFormularioDto> dto = criaListaDeFieldsErrors(ex);
		return handleExceptionInternal(ex, dto, headers, HttpStatus.BAD_REQUEST, request);
	}

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler({ RegistroDuplicadoException.class })
	public ResponseEntity<Object> handleRegistroDuplicadoException(
			RegistroDuplicadoException ex, WebRequest request) {
		String statusError = HttpStatus.BAD_REQUEST.toString();
		String message = ex.getMessage();
		String trace = ex.toString();
		List<Erro> erros = Arrays.asList(new Erro(statusError, message, trace));
		return handleExceptionInternal(ex, erros, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler({ RegistroNaoExisteException.class })
	public ResponseEntity<Object> handleRegistroNaoExisteException(
			RegistroNaoExisteException ex, WebRequest request) {
		String statusError = HttpStatus.BAD_REQUEST.toString();
		String message = ex.getMessage();
		String trace = ex.toString();
		List<Erro> erros = Arrays.asList(new Erro(statusError, message, trace));
		return handleExceptionInternal(ex, erros, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}




	private List<ErroDeFormularioDto> criaListaDeFieldsErrors(MethodArgumentNotValidException ex) {
		List<ErroDeFormularioDto> dto = new ArrayList<>();
		List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
		fieldErrors.forEach(e -> {
			String mensagem = messageSource.getMessage(e, LocaleContextHolder.getLocale());
			ErroDeFormularioDto erro = new ErroDeFormularioDto(e.getField(), mensagem);
			dto.add(erro);
		});
		return dto;
	}

	public static class Erro {

		private String status;
		private String message;
		private String trace;

		public Erro(String status, String message, String trace) {
			this.status = status;
			this.message = message;
			this.trace = trace;
		}

		public String getStatus() {
			return status;
		}
		public String getMessage() {
			return message;
		}
		public String getTrace() {
			return trace;
		}

	}

}
